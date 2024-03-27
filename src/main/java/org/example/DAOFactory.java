package org.example;

import java.sql.SQLException;

public  class DAOFactory {


    public static GenericDAO<Article> getArticleDAO() throws SQLException {

        return new ArticleDAO();

    }


    public static GenericDAO<TypeBiere> getTypeBiereDAO() throws SQLException {

        return new TypeBiereDAO();

    }

    public static GenericDAO<Couleur> getCouleurDAO() throws SQLException {

        return new CouleurDAO();

    }

    public static GenericDAO<Continent> getContinentDAO() throws SQLException {

        return new ContinentDAO();

    }

    public static GenericDAO<Pays> getPaysDAO() throws SQLException {

        return new PaysDAO();

    }

    public static GenericDAO<Fabricant> getFabricantDAO() throws SQLException {

        return new FabricantDAO();

    }

    public static GenericDAO<Marque> getMarqueDAO() throws SQLException {

        return new MarqueDAO();

    }

    public static GenericDAO<Ticket> getTicketDAO() throws SQLException {

        return new TicketDAO();

    }

    public static GenericDAO<Vendre> getVendreDAO() throws SQLException {

        return new VendreDAO();

    }


}
