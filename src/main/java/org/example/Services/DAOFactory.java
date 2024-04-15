package org.example.Services;

import org.example.DAO.*;
import org.example.Entity.*;
import org.example.Util.Database;

import java.sql.SQLException;

public  class DAOFactory {


    private static StoredProcedure storedProcedure;

    static {
        try {
            storedProcedure = new StoredProcedure(Database.connectionToDB());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static GenericDAO<Article> getArticleDAO() throws SQLException {

        return new ArticleDAO(storedProcedure);

    }


    public static GenericDAO<TypeBiere> getTypeBiereDAO() throws SQLException {

        return new TypeBiereDAO(storedProcedure);

    }

    public static GenericDAO<Couleur> getCouleurDAO() throws SQLException {

        return new CouleurDAO(storedProcedure);

    }

    public static GenericDAO<Continent> getContinentDAO() throws SQLException {

        return new ContinentDAO(storedProcedure);

    }

    public static GenericDAO<Pays> getPaysDAO() throws SQLException {

        return new PaysDAO(storedProcedure);

    }

    public static GenericDAO<Fabricant> getFabricantDAO() throws SQLException {

        return new FabricantDAO(storedProcedure);

    }

    public static GenericDAO<Marque> getMarqueDAO() throws SQLException {

        return new MarqueDAO(storedProcedure);

    }

    public static GenericDAO<Ticket> getTicketDAO() throws SQLException {

        return new TicketDAO(storedProcedure);

    }

    public static GenericDAO<Vendre> getVendreDAO() throws SQLException {

        return new VendreDAO(storedProcedure);

    }


}
