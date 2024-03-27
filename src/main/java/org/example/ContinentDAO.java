package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ContinentDAO implements GenericDAO<Continent> {

    private StoredProcedure StoredProcedure;

    public ContinentDAO() throws SQLException {

        this.StoredProcedure = new StoredProcedure();
    }

    @Override
    public Continent findById(int id) {

        try {

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdContinent(?)}", id);

            if (resultStoredProcedure.next()) {

                int idContinent = resultStoredProcedure.getInt("ID_CONTINENT");
                String nomContinent = resultStoredProcedure.getString("NOM_CONTINENT");

                return new Continent(idContinent, nomContinent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Continent create(Continent continent) {

        try {

            StoredProcedure.procedureCreate("{call createContinent(?)}",

                    continent.getNomContinent()
            );

            return continent;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Continent update(Continent continent) {

        try {

            StoredProcedure.procedureUpdate("{call updateContinent(?, ?)}",

                    continent.getNomContinent(),
                    continent.getIdContinent()
            );

            return continent;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        try {


            StoredProcedure.procedureDeleteById("{call deleteContinentById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public Map<Integer, Continent> findAll() throws SQLException {

        Map<Integer, Continent> arrayContinent = new HashMap<>();

        ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllContinent()}");

        while (resultStoredProcedure.next()) {

            int idContinent = resultStoredProcedure.getInt("ID_CONTINENT");
            String nomContinent = resultStoredProcedure.getString("NOM_CONTINENT");

            Continent continent = new Continent(idContinent, nomContinent);

            arrayContinent.put(idContinent, continent);
        }

        return arrayContinent;
    }

}