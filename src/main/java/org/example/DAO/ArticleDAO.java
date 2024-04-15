package org.example.DAO;

import org.example.Entity.Article;
import org.example.Entity.TypeBiere;
import org.example.Entity.Couleur;
import org.example.Entity.Marque;
import org.example.Services.DAOFactory;
import org.example.Services.GenericDAO;
import org.example.Services.StoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ArticleDAO implements GenericDAO<Article> {


    private StoredProcedure StoredProcedure;

    public ArticleDAO(StoredProcedure storedProcedure) {

        this.StoredProcedure = storedProcedure;
    }


    public Article create(Article article) {

        try {

            // Récupérer les objets Marque, Couleur et TypeBiere correspondant aux identifiants
            Marque marque = DAOFactory.getMarqueDAO().findById(article.getIdMarque().getIdMarque());
            Couleur couleur = DAOFactory.getCouleurDAO().findById(article.getIdCouleur().getIdCouleur());
            TypeBiere typeBiere = DAOFactory.getTypeBiereDAO().findById(article.getIdType().getIdType());


            StoredProcedure.procedureCreateArticle("{call createArticle(?, ?, ?, ?, ?, ?, ?)}",

                    article.getNomArticle(),
                    article.getPrixAchat(),
                    article.getVolume(),
                    article.getTitrage(),
                    marque,
                    couleur,
                    typeBiere
            );

            return article;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Article findById(int id) {

        try {

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindById("{call findOneByIdArticle(?)}", id);

            if (resultStoredProcedure.next()) {

                int idArticle = resultStoredProcedure.getInt("ID_ARTICLE");
                String nomArticle = resultStoredProcedure.getString("NOM_ARTICLE");
                float prixAchat = resultStoredProcedure.getFloat("PRIX_ACHAT");
                int volume = resultStoredProcedure.getInt("VOLUME");
                float titrage = resultStoredProcedure.getFloat("TITRAGE");
                int idMarque = resultStoredProcedure.getInt("ID_MARQUE");
                int idCouleur = resultStoredProcedure.getInt("ID_COULEUR");
                int idType = resultStoredProcedure.getInt("ID_TYPE");

                Marque marque = DAOFactory.getMarqueDAO().findById(idMarque);
                Couleur couleur = DAOFactory.getCouleurDAO().findById(idCouleur);
                TypeBiere type = DAOFactory.getTypeBiereDAO().findById(idType);

                Article article = new Article(idArticle, nomArticle, prixAchat, volume, titrage, marque, couleur, type);
                return article;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Article update(Article article) {

        try {

            Marque marque = DAOFactory.getMarqueDAO().findById(article.getIdMarque().getIdMarque());
            Couleur couleur = DAOFactory.getCouleurDAO().findById(article.getIdCouleur().getIdCouleur());
            TypeBiere typeBiere = DAOFactory.getTypeBiereDAO().findById(article.getIdType().getIdType());

            StoredProcedure.procedureUpdateArticle("{call updateArticle(?, ?, ?, ?, ?, ?, ?, ?)}",

                    article.getNomArticle(),
                    article.getPrixAchat(),
                    article.getVolume(),
                    article.getTitrage(),
                    marque,
                    couleur,
                    typeBiere,
                    article.getIdArticle()

            );

            return article;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        try {

            StoredProcedure.procedureDeleteById("{call deleteArticleById(?)}", id);

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


    public Map<Integer, Article> findAll() {

        Map<Integer, Article> arrayArticle = new HashMap<>();

        try {

            Map<Integer, Marque> arrayMarque = DAOFactory.getMarqueDAO().findAll();
            Map<Integer, TypeBiere> arrayTypeBiere = DAOFactory.getTypeBiereDAO().findAll();
            Map<Integer, Couleur> arrayCouleur = DAOFactory.getCouleurDAO().findAll();

            ResultSet resultStoredProcedure = StoredProcedure.executeProcedure("{call findAllArticle()}");

            while (resultStoredProcedure.next()) {

                int idArticle = resultStoredProcedure.getInt("ID_ARTICLE");
                String nomArticle = resultStoredProcedure.getString("NOM_ARTICLE");
                float prixAchat = resultStoredProcedure.getFloat("PRIX_ACHAT");
                int volume = resultStoredProcedure.getInt("VOLUME");
                float titrage = resultStoredProcedure.getFloat("TITRAGE");
                int idMarque = resultStoredProcedure.getInt("ID_MARQUE");
                int idCouleur = resultStoredProcedure.getInt("ID_COULEUR");
                int idType = resultStoredProcedure.getInt("ID_TYPE");

                Marque marque = arrayMarque.get(idMarque);
                Couleur couleur = arrayCouleur.get(idCouleur);
                TypeBiere type = arrayTypeBiere.get(idType);

                Article article = new Article(idArticle, nomArticle, prixAchat, volume, titrage, marque, couleur, type);

                arrayArticle.put(idArticle, article);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayArticle;
    }


}