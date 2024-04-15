package org.example.DAO;

import org.example.Entity.Fabricant;
import org.example.Entity.Marque;
import org.example.Entity.Pays;
import org.example.Services.DAOFactory;
import org.example.Services.GenericDAO;
import org.example.Services.StoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MarqueDAO implements GenericDAO<Marque> {


    private StoredProcedure StoredProcedure;

    public MarqueDAO(StoredProcedure storedProcedure) {

        this.StoredProcedure = storedProcedure;
    }


    @Override
    public Marque create(Marque marque) {

        try {

            // Récupérer les objets correspondant aux identifiants
            Pays pays = DAOFactory.getPaysDAO().findById(marque.getIdPays().getIdPays());
            Fabricant fabricant = DAOFactory.getFabricantDAO().findById(marque.getIdFabricant().getIdFabricant());


            StoredProcedure.procedureCreateMarque("{call createMarque(?, ?, ?)}",

                    marque.getNomMarque(),
                    pays,
                    fabricant

            );

            return marque;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Marque findById(int id) {

        try {

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdMarque(?)}", id);

            if (resultStoredProcedure.next()) {

                int idMarque = resultStoredProcedure.getInt("ID_MARQUE");
                String nomMarque = resultStoredProcedure.getString("NOM_MARQUE");
                int idPays = resultStoredProcedure.getInt("ID_PAYS");
                int idFabricant = resultStoredProcedure.getInt("ID_FABRICANT");

                Pays pays = DAOFactory.getPaysDAO().findById(idPays);
                Fabricant fabricant = DAOFactory.getFabricantDAO().findById(idFabricant);

                return new Marque(idMarque, nomMarque, pays, fabricant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Marque update(Marque marque) {

        try {

            Fabricant fabricant = DAOFactory.getFabricantDAO().findById(marque.getIdFabricant().getIdFabricant());

            StoredProcedure.procedureUpdateMarque("{call updateMarque(?, ?, ?)}",

                    marque.getNomMarque(),
                    fabricant,
                    marque.getIdMarque()

            );

            return marque;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

        try {

            StoredProcedure.procedureDeleteById("{call deleteMarqueById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public Map<Integer, Marque> findAll() {

        Map<Integer, Marque> arrayMarque = new HashMap<>();

        try {

            Map<Integer, Pays> arrayPays = DAOFactory.getPaysDAO().findAll();
            Map<Integer, Fabricant> arrayFabricant = DAOFactory.getFabricantDAO().findAll();

            ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllMarque()}");

            while (resultStoredProcedure.next()) {

                int idMarque = resultStoredProcedure.getInt("ID_MARQUE");
                String nomMarque = resultStoredProcedure.getString("NOM_MARQUE");
                int idPays = resultStoredProcedure.getInt("ID_PAYS");
                int idFabricant = resultStoredProcedure.getInt("ID_FABRICANT");

                Pays pays = arrayPays.get(idFabricant);
                Fabricant fabricant = arrayFabricant.get(idFabricant);

                Marque marque = new Marque(idMarque, nomMarque, pays, fabricant);

                arrayMarque.put(idMarque, marque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayMarque;
    }
}