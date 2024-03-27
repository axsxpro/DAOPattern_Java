package org.example;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

            try {

                // Création d'une instance de ArticleDAO et récupération des articles
                ArticleDAO articleDAO = new ArticleDAO();
                Map<Integer, Article> tableArticle = articleDAO.findAll();

                // Itérer à travers les articles pour les afficher
                for (Article article : tableArticle.values()) {
                    System.out.println(article);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                // Gérer l'exception de manière appropriée
            }
//
//
//
//            try {
//
//                // Création d'une instance de ArticleDAO et récupération des articles
//                ArticleDAO articleDAO = new ArticleDAO();
//                Article article = articleDAO.findById(1);
//
//                System.out.println(article);
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                // Gérer l'exception de manière appropriée
//            }
//
//
//
//            try {
//
//                TypeBiereDAO typeBiereDAO = new TypeBiereDAO();
//                TypeBiere typeBiere = typeBiereDAO.findById(1);
//
//                System.out.println(typeBiere);
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                // Gérer l'exception de manière appropriée
//            }
//
//
//
//            try {
//
//                PaysDAO paysDAO = new PaysDAO();
//                Map<Integer, Pays> tablePays = paysDAO.findAll();
//
//                for (Pays pays : tablePays.values()) {
//                    System.out.println(pays);
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//                // Gérer l'exception de manière appropriée
//            }
//
//
//            try {
//
//                MarqueDAO marqueDAO = new MarqueDAO();
//                Map<Integer, Marque> tableMarque = marqueDAO.findAll();
//
//
//                for (Marque marque: tableMarque.values()) {
//                    System.out.println(marque);
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }

//
//            try {
//
//                TicketDAO ticketDAO = new TicketDAO();
//                Map<Integer, Ticket> tableTicket = ticketDAO.findAll();
//
//                for (Ticket ticket : tableTicket.values()) {
//                    System.out.println(ticket);
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//


//
//            try {
//
//                ArticleDAO articleDAO = new ArticleDAO();
//                articleDAO.delete(3921);
//
//                System.out.println("Article deleted successfully.");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//            }

//
//        try {
//
//            MarqueDAO marqueDAO = new MarqueDAO();
//            marqueDAO.delete(580);
//
//            System.out.println("Article deleted successfully.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }


//            try {
//
//                // Récupérer les objets Marque, Couleur et TypeBiere existants par leur ID
//                Marque marque = DAOFactory.getMarqueDAO().findById(2);
//                Couleur couleur = DAOFactory.getCouleurDAO().findById(1);
//                TypeBiere typeBiere  = DAOFactory.getTypeBiereDAO().findById(3);
//
//                // Créer un nouvel article avec les objets Marque, Couleur et TypeBiere récupérés
//                // mettre l'id article à zéro (auto-incrémentation déjà inclus dans la bdd)
//                Article newArticle = new Article(0, "Nouvel article", 500, 33, 25, marque, couleur, typeBiere);
//
//                Article createdArticle = DAOFactory.getArticleDAO().create(newArticle);
//
//                System.out.println("New article created !" + createdArticle);
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }


//        try {
//
//            // Récupérer les objets existants par leur ID
//            Pays pays = DAOFactory.getPaysDAO().findById(2);
//            Fabricant fabricant = DAOFactory.getFabricantDAO().findById(5);
//
//            // Créer un nouvel article avec les objets Marque, Couleur et TypeBiere récupérés
//            // mettre l'id article à zéro (auto-incrémentation déjà inclus dans la bdd)
//            Marque newMarque = new Marque(0, "brand new", pays, fabricant);
//
//            Marque createdMarque = DAOFactory.getMarqueDAO().create(newMarque);
//
//            System.out.println("New article created !" + createdMarque);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//
//
//            Continent continent = DAOFactory.getContinentDAO().findById(3);
//
//            Pays newPays = new Pays(0, "paysss", continent);
//
//            Pays pays = DAOFactory.getPaysDAO().create(newPays);
//
//            System.out.println("New pays created !" + newPays);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//
//        try {
//
//                PaysDAO paysDAO = new PaysDAO();
//                paysDAO.delete(38);
//
//                System.out.println("pays deleted successfully.");
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//
//        }

//
//        try {
//
//            Continent newContinent = new Continent(0, "continent");
//
//            Continent continent = DAOFactory.getContinentDAO().create(newContinent);
//
//            System.out.println("New continent created !" + newContinent);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//
//        try {
//
//            ContinentDAO continentDAO = new ContinentDAO();
//            continentDAO.delete(6);
//
//            System.out.println("continent deleted successfully.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }


//        try {
//
//            Fabricant newFabricant = new Fabricant(0, "unfabricant");
//
//            Fabricant Fabricant  = DAOFactory.getFabricantDAO().create(newFabricant);
//
//            System.out.println("New fabricant created !" + newFabricant);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//
//            FabricantDAO fabricantDAO = new FabricantDAO();
//            fabricantDAO.delete(11);
//
//            System.out.println("fabricant deleted successfully.");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//
//        }


//        try {
//
//            Continent continent = DAOFactory.getContinentDAO().findById(7);
//
//            continent.setNomContinent("nouveau continent");
//
//            Continent updateContinent  = DAOFactory.getContinentDAO().update(continent);
//
//            System.out.println("updated !" + updateContinent);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//
//            Article article = DAOFactory.getArticleDAO().findById(3931);
//
//            article.setNomArticle("ARTICLE UPDATE");
//
//            Marque idMarque = DAOFactory.getMarqueDAO().findById(5);
//            article.setIdMarque(idMarque);
//
//            Article articleUpdated  = DAOFactory.getArticleDAO().update(article);
//
//            System.out.println("updated !" + articleUpdated);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//
//            Pays pays = DAOFactory.getPaysDAO().findById(39);
//
//            Continent continent = DAOFactory.getContinentDAO().findById(1);
//            pays.setIdContinent(continent);
//
//            Pays paysUpdated  = DAOFactory.getPaysDAO().update(pays);
//
//            System.out.println("updated !" + paysUpdated);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//
//        try {
//            Map<Integer, Vendre> tableVendre = DAOFactory.getVendreDAO().findAll();
//
//            for (Map.Entry<Integer, Vendre> entry : tableVendre.entrySet()) {
//                int id = entry.getKey();
//                Vendre vendre = entry.getValue();
//
//                System.out.println("ID: " + id + ", Vendre: " + vendre);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        try {
//
//
//
//        Ticket ticket =  DAOFactory.getTicketDAO().findById(5);
//        System.out.println(ticket);
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Gérer l'exception de manière appropriée
//        }


//        try {
//
//            Ticket newTicket = new Ticket(2030, 50, Date.valueOf("2023-03-25"), Time.valueOf("08:06:05"));
//
//            Ticket ticket  = DAOFactory.getTicketDAO().create(newTicket);
//
//            System.out.println("New ticket created !" + ticket);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//
//           try {
//
//                Article article = DAOFactory.getArticleDAO().findById(1);
//
//                Vendre vendre = new Vendre(2014, 5, article, 33, 25.0f);
//
//                Vendre newVente = DAOFactory.getVendreDAO().create(vendre);
//
//                System.out.println("New article created !" + newVente);
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }


//        try {
//
//            Ticket ticket = DAOFactory.getTicketDAO().findById(6);
//
//            ticket.setDateVente(Date.valueOf("2023-03-25"));
//
//            DAOFactory.getTicketDAO().update(ticket);
//
//            System.out.println(" updated !" + ticket);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//
//      try {
//
//         DAOFactory.getTicketDAO().delete(25);
//
//         System.out.println("deleted successfully.");
//
//      } catch (SQLException e) {
//           e.printStackTrace();
//       }


//        try {
//
//        Vendre vendre =  DAOFactory.getVendreDAO().findById(3);
//        System.out.println(vendre);
//
//
//      } catch (SQLException e) {
//         e.printStackTrace();
//         // Gérer l'exception de manière appropriée
//       }



//
//      try {
//
//
//         DAOFactory.getVendreDAO().delete(2);
//
//         System.out.println("deleted successfully.");
//
//      } catch (SQLException e) {
//           e.printStackTrace();
//       }



    }

}




