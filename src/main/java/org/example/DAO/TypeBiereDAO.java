package org.example.DAO;

import org.example.Entity.TypeBiere;
import org.example.Services.GenericDAO;
import org.example.Services.StoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TypeBiereDAO implements GenericDAO<TypeBiere> {


    private StoredProcedure StoredProcedure;

    public TypeBiereDAO(StoredProcedure storedProcedure) {

        this.StoredProcedure = storedProcedure;
    }


    public TypeBiere create(TypeBiere typeBiere) {

        try {

            StoredProcedure.procedureCreate("{call createTypeBiere(?)}",

                    typeBiere.getNomType()
            );

            return typeBiere;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public TypeBiere findById(int id) {

        try {

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdType(?)}", id);

            if (resultStoredProcedure.next()) {

                int idType = resultStoredProcedure.getInt("ID_TYPE");
                String nomType = resultStoredProcedure.getString("NOM_TYPE");

                TypeBiere typeBiere = new TypeBiere(idType, nomType);
                return typeBiere;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public TypeBiere update(TypeBiere typeBiere) {

        try {

            StoredProcedure.procedureUpdate("{call updateTypeBiere(?, ?)}",

                    typeBiere.getNomType(),
                    typeBiere.getIdType()
            );

            return typeBiere;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        try {

            StoredProcedure.procedureDeleteById("{call deleteTypeById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

    public Map<Integer, TypeBiere> findAll() throws SQLException {

        Map<Integer, TypeBiere> arrayTypeBiere = new HashMap<>();

        // Appel de la procédure stockée pour récupérer les types de bière
        ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllType()}");

        // Parcours des données récupérées dans le resultStoredProcedure
        while (resultStoredProcedure.next()) {

            int idType = resultStoredProcedure.getInt("ID_TYPE");
            String nomType = resultStoredProcedure.getString("NOM_TYPE");

            // Création de l'objet TypeBiere avec les données récupérées
            TypeBiere typeBiere = new TypeBiere(idType, nomType);

            // Stockage de l'objet TypeBiere dans le map
            arrayTypeBiere.put(idType, typeBiere);

        }

        return arrayTypeBiere;
    }


}
