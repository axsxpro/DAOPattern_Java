package org.example.Services;

import org.example.Entity.*;

import java.sql.*;


public class StoredProcedure {

    private final Connection connection;

    // Constructeur
    public StoredProcedure(Connection connection) {

        this.connection = connection;
    }


    // methode procédure stocké pour rechercher toute la liste d'une table
    public ResultSet executeProcedure(String callProcedureSQL) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);

        return callableStatement.executeQuery();
    }


    // Méthode pour rechercher par l'id
    public ResultSet procedureFindById(String callProcedureSQL, int idType) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, idType); // 1 indique que c'est le premier paramètre de la procédure stockée, idType est la valeur passée en argument

        return callableStatement.executeQuery();
    }


    public ResultSet procedureFindTicketById(String callProcedureSQL, int numTicket, int annee) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, numTicket);
        callableStatement.setInt(2, annee);

        return callableStatement.executeQuery();
    }

    public ResultSet procedureFindVendreById(String callProcedureSQL, int annee, int numTicket, int idArticle) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, annee);
        callableStatement.setInt(2,numTicket);
        callableStatement.setInt(3, idArticle);

        return callableStatement.executeQuery();
    }

    //methode pour supprimer par son id
    public ResultSet procedureDeleteById(String callProcedureSQL, int id) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, id);

        return callableStatement.executeQuery();
    }


    public ResultSet procedureDeleteTicket(String callProcedureSQL, int numTicket, int annee) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, numTicket);
        callableStatement.setInt(2, annee);

        return callableStatement.executeQuery();
    }


    public ResultSet procedureDeleteVendre(String callProcedureSQL, int annee, int numTicket, int idArticle) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, annee);
        callableStatement.setInt(2, numTicket);
        callableStatement.setInt(3, idArticle);

        return callableStatement.executeQuery();
    }


    public ResultSet procedureCreateArticle(String callProcedureSQL, String nomArticle, float prixAchat, int volume, float titrage, Marque marque, Couleur couleur, TypeBiere type) throws SQLException {

            CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
            callableStatement.setString(1, nomArticle);
            callableStatement.setFloat(2, prixAchat);
            callableStatement.setInt(3, volume);
            callableStatement.setFloat(4, titrage);
            callableStatement.setInt(5, marque.getIdMarque()); // Utiliser getIdMarque() pour obtenir l'ID de la marque
            callableStatement.setInt(6, couleur.getIdCouleur()); // Utiliser getIdCouleur() pour obtenir l'ID de la couleur
            callableStatement.setInt(7, type.getIdType()); // Utiliser getIdType() pour obtenir l'ID du type de bière

            return callableStatement.executeQuery();
    }


    public ResultSet procedureCreateTicket(String callProcedureSQL, int annee, int numTicket, java.util.Date DateVente,  java.sql.Time heureVente) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, annee);
        callableStatement.setInt(2, numTicket);
        callableStatement.setDate(3, (Date) DateVente);
        callableStatement.setTime(4, heureVente);

        return callableStatement.executeQuery();
    }


    public ResultSet procedureCreateVendre(String callProcedureSQL, int annee, int numTicket, Article article, int quantite, float prixVente) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, annee);
        callableStatement.setInt(2, numTicket);
        callableStatement.setInt(3, article.getIdArticle());
        callableStatement.setInt(4, quantite);
        callableStatement.setFloat(5, prixVente);

        return callableStatement.executeQuery();
    }


    public ResultSet procedureCreateMarque(String callProcedureSQL, String nomArticle, Pays pays, Fabricant fabricant) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nomArticle);
        callableStatement.setInt(2, pays.getIdPays());
        callableStatement.setInt(3, fabricant.getIdFabricant());

        return callableStatement.executeQuery();

    }


    public ResultSet procedureCreatePays(String callProcedureSQL, String nomPays, Continent continent) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nomPays);
        callableStatement.setInt(2, continent.getIdContinent());

        return callableStatement.executeQuery();

    }

    public ResultSet procedureCreate(String callProcedureSQL, String nom) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nom);

        return callableStatement.executeQuery();

    }

    //type de retour de la méthode en int pour correspondre à la valeur de retour de executeUpdate()
    public int procedureUpdate(String callProcedureSQL, String nom, int id) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nom);
        callableStatement.setInt(2, id); // Utilisez le deuxième paramètre pour l'ID

        return callableStatement.executeUpdate();

    }


    public int procedureUpdateArticle(String callProcedureSQL, String nomArticle, float prixAchat, int volume, float titrage, Marque marque, Couleur couleur, TypeBiere type, int idArticle) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nomArticle);
        callableStatement.setFloat(2, prixAchat);
        callableStatement.setInt(3, volume);
        callableStatement.setFloat(4, titrage);
        callableStatement.setInt(5, marque.getIdMarque()); // Utiliser getIdMarque() pour obtenir l'ID de la marque
        callableStatement.setInt(6, couleur.getIdCouleur()); // Utiliser getIdCouleur() pour obtenir l'ID de la couleur
        callableStatement.setInt(7, type.getIdType()); // Utiliser getIdType() pour obtenir l'ID du type de bière
        callableStatement.setInt(8, idArticle);

        return callableStatement.executeUpdate();
    }


    public int procedureUpdatePays(String callProcedureSQL, String nomPays, Continent continent, int idPays) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nomPays);
        callableStatement.setInt(2, continent.getIdContinent());
        callableStatement.setInt(3, idPays);

        return callableStatement.executeUpdate();
    }

    public int procedureUpdateMarque(String callProcedureSQL, String nomMarque, Fabricant fabricant, int idMarque) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setString(1, nomMarque);
        callableStatement.setInt(2, fabricant.getIdFabricant());
        callableStatement.setInt(3, idMarque);

        return callableStatement.executeUpdate();
    }


    public int procedureUpdateTicket(String callProcedureSQL, int annee, int numTicket, java.util.Date DateVente,  java.sql.Time heureVente) throws SQLException {

        CallableStatement callableStatement = connection.prepareCall(callProcedureSQL);
        callableStatement.setInt(1, annee);
        callableStatement.setInt(2, numTicket);
        callableStatement.setDate(3, (Date) DateVente);
        callableStatement.setTime(4, heureVente);

        return callableStatement.executeUpdate();
    }


}
