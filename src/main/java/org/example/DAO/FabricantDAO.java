package org.example.DAO;

import org.example.Entity.Fabricant;
import org.example.Services.GenericDAO;
import org.example.Services.StoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class FabricantDAO implements GenericDAO<Fabricant> {


    private StoredProcedure StoredProcedure;

    public FabricantDAO(StoredProcedure storedProcedure) {

        this.StoredProcedure = storedProcedure;
    }


    @Override
    public Fabricant create(Fabricant fabricant) {

        try {

            StoredProcedure.procedureCreate("{call createFabricant(?)}",

                    fabricant.getNomFabricant()
            );

            return fabricant;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Fabricant findById(int id) {
        try {

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdFabricant(?)}", id);

            if (resultStoredProcedure.next()) {

                int idFabricant = resultStoredProcedure.getInt("ID_FABRICANT");
                String nomFabricant = resultStoredProcedure.getString("NOM_FABRICANT");

                return new Fabricant(idFabricant, nomFabricant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Fabricant update(Fabricant fabricant) {

        try {

            StoredProcedure.procedureUpdate("{call updateFabricant(?, ?)}",

                    fabricant.getNomFabricant(),
                    fabricant.getIdFabricant()
            );

            return fabricant;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void delete(int id) {

        try {

            StoredProcedure.procedureDeleteById("{call deleteFabricantById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    public Map<Integer, Fabricant> findAll() {

        Map<Integer, Fabricant> arrayFabricant = new HashMap<>();

        try {

            ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllFabricant()}");

            while (resultStoredProcedure.next()) {

                int idFabricant = resultStoredProcedure.getInt("ID_FABRICANT");
                String nomFabricant = resultStoredProcedure.getString("NOM_FABRICANT");

                Fabricant fabricant = new Fabricant(idFabricant, nomFabricant);
                arrayFabricant.put(idFabricant, fabricant);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayFabricant;
    }
}