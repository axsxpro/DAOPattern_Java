package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PaysDAO implements GenericDAO<Pays> {

    private StoredProcedure StoredProcedure;

    public PaysDAO() throws SQLException {

        this.StoredProcedure = new StoredProcedure();

    }


    @Override
    public Pays create(Pays pays) {

        try {

            // Récupérer les objets correspondant aux identifiants
            Continent continent = DAOFactory.getContinentDAO().findById(pays.getIdContinent().getIdContinent());

            StoredProcedure.procedureCreatePays("{call createPays(?, ?)}",

                    pays.getNomPays(),
                    continent

            );

            return pays;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Pays findById(int id) {

        try {

            Map<Integer, Continent> arrayContinent = DAOFactory.getContinentDAO().findAll();

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdPays(?)}", id);

            if (resultStoredProcedure.next()) {

                int idPays = resultStoredProcedure.getInt("ID_PAYS");
                String nomPays = resultStoredProcedure.getString("NOM_PAYS");
                int idContinent = resultStoredProcedure.getInt("ID_CONTINENT");

                Continent continent = arrayContinent.get(idContinent);

                return new Pays(idPays, nomPays, continent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Pays update(Pays pays) {

        try {

            Continent continent = DAOFactory.getContinentDAO().findById(pays.getIdContinent().getIdContinent());

            StoredProcedure.procedureUpdatePays("{call updatePays(?, ?, ?)}",

                    pays.getNomPays(),
                    continent,
                    pays.getIdPays()

            );

            return pays;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        try {

            StoredProcedure.procedureDeleteById("{call deletePaysById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public Map<Integer, Pays> findAll() throws SQLException {

        Map<Integer, Pays> arrayPays = new HashMap<>();

        try {

            Map<Integer, Continent> arrayContinent = DAOFactory.getContinentDAO().findAll();

            ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllPays()}");

            while (resultStoredProcedure.next()) {

                int idPays = resultStoredProcedure.getInt("ID_PAYS");
                String nomPays = resultStoredProcedure.getString("NOM_PAYS");
                int idContinent = resultStoredProcedure.getInt("ID_CONTINENT");

                Continent continent = arrayContinent.get(idContinent);

                Pays pays = new Pays(idPays, nomPays, continent);

                arrayPays.put(idPays, pays);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return arrayPays;
    }

}