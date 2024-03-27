package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CouleurDAO implements GenericDAO<Couleur> {

    private StoredProcedure StoredProcedure;

    public CouleurDAO() throws SQLException {

        this.StoredProcedure = new StoredProcedure();
    }

    public Couleur create(Couleur couleur) {

        try {

            StoredProcedure.procedureCreate("{call createCouleur(?)}",

                    couleur.getNomCouleur()
            );

            return couleur;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Couleur findById(int id) {

        try {

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdCouleur(?)}", id);

            if (resultStoredProcedure.next()) {

                int idCouleur = resultStoredProcedure.getInt("ID_COULEUR");
                String nomCouleur = resultStoredProcedure.getString("NOM_COULEUR");

                Couleur couleur = new Couleur(idCouleur, nomCouleur);

                return couleur;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Couleur update(Couleur couleur) {

        try {

            StoredProcedure.procedureUpdate("{call updateCouleur(?, ?)}",

                    couleur.getNomCouleur(),
                    couleur.getIdCouleur()
            );

            return couleur;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        try {

            StoredProcedure.procedureDeleteById("{call deleteCouleurById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public Map<Integer, Couleur> findAll() throws SQLException {

        Map<Integer, Couleur> arrayCouleur = new HashMap<>();

        ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllCouleur()}");

        while (resultStoredProcedure.next()) {

            int idCouleur = resultStoredProcedure.getInt("ID_COULEUR");
            String nomCouleur = resultStoredProcedure.getString("NOM_COULEUR");

            Couleur couleur = new Couleur(idCouleur, nomCouleur);

            arrayCouleur.put(idCouleur, couleur);

        }

        return arrayCouleur;
    }

}
