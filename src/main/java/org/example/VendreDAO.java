package org.example;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class VendreDAO implements GenericDAO<Vendre> {

    private StoredProcedure StoredProcedure;
    private static Map<Integer, Vendre> arrayVendre = new HashMap<>();

    public VendreDAO() throws SQLException {

        this.StoredProcedure = new StoredProcedure();
    }

    @Override
    public Vendre create(Vendre vendre) {

        try {

            Article article = DAOFactory.getArticleDAO().findById(vendre.getIdArticle().getIdArticle());

            StoredProcedure.procedureCreateVendre("{call createVendre(?, ?, ?, ?,?)}",

                    vendre.getAnnee(),
                    vendre.getNumeroTicket(),
                    article,
                    vendre.getQuantite(),
                    vendre.getPrixVente()
            );

            return vendre;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Vendre findById(int id) {


        try {

            //initialisation des données
            DAOFactory.getVendreDAO().findAll();


            //recherche de la vente dans le tableau par son id
            Vendre venteFound = VendreDAO.arrayVendre.get(id);
            // récupération de l'année et du numéro de ticket
            int anneeVente = venteFound.getAnnee();
            int numTicket = venteFound.getNumeroTicket();
            int idArticleVente = venteFound.getIdArticle().getIdArticle();


            ResultSet resultStoredProcedure = StoredProcedure.procedureFindVendreById("{call findVendreById(?, ?, ?)}", anneeVente, numTicket, idArticleVente);


            if (resultStoredProcedure.next()) {

                int annee = resultStoredProcedure.getInt("ANNEE");
                int numeroTicket = resultStoredProcedure.getInt("NUMERO_TICKET");
                int idArticle = resultStoredProcedure.getInt("ID_ARTICLE");
                int quantite = resultStoredProcedure.getInt("QUANTITE");
                float prixVente = resultStoredProcedure.getFloat("PRIX_VENTE");

                Article article = DAOFactory.getArticleDAO().findById(idArticle);

                Vendre vendre = new Vendre(annee, numeroTicket, article, quantite, prixVente);
                return vendre;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Vendre update(Vendre vendre) {

        //on ne peut pas update une vente
        return null;

    }


    @Override
    public void delete(int id) {

        try {

            DAOFactory.getVendreDAO().findAll();

            //recherche de la vente dans le tableau par son id
            Vendre venteFound = VendreDAO.arrayVendre.get(id);

            // récupération de l'année et du numéro de ticket
            int anneeVente = venteFound.getAnnee();
            int numTicket = venteFound.getNumeroTicket();
            int idArticleVente = venteFound.getIdArticle().getIdArticle();


            StoredProcedure.procedureDeleteVendre("{call deleteVendre(?, ?, ?)}", anneeVente, numTicket, idArticleVente);

        } catch (SQLException e) {
            e.printStackTrace();

        }


    }


    public Map<Integer, Vendre> findAll() {


        int id = 1; // Initialisation de l'identifiant

        try {

            //chargement de tous les articles
            Map<Integer, Article> arrayArticle = DAOFactory.getArticleDAO().findAll();

            //attention limite de données mise dans la procédure stocké findAllVente
            ResultSet resultSet = StoredProcedure.executeProcedure("{call findAllVente()}");

            while (resultSet.next()) {

                int annee = resultSet.getInt("ANNEE");
                int numeroTicket = resultSet.getInt("NUMERO_TICKET");
                int idArticle = resultSet.getInt("ID_ARTICLE");
                int quantite = resultSet.getInt("QUANTITE");
                float prixVente = resultSet.getFloat("PRIX_VENTE");

                Article article = arrayArticle.get(idArticle);

                Vendre vendre = new Vendre(annee, numeroTicket, article, quantite, prixVente);

                arrayVendre.put(id++, vendre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayVendre;
    }

}
