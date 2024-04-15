package org.example.DAO;

import org.example.Entity.Ticket;
import org.example.Services.DAOFactory;
import org.example.Services.GenericDAO;
import org.example.Services.StoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class TicketDAO implements GenericDAO<Ticket> {


    private StoredProcedure StoredProcedure;
    private static Map<Integer, Ticket> arrayTicket = new HashMap<>();


    public TicketDAO(StoredProcedure storedProcedure) {

        this.StoredProcedure = storedProcedure;
    }


    @Override
    public Ticket create(Ticket ticket) {

        try {

            StoredProcedure.procedureCreateTicket("{call createTicket(?, ?, ?, ?)}",

                    ticket.getAnnee(),
                    ticket.getNumeroTicket(),
                    ticket.getDateVente(),
                    ticket.getHeureVente()
            );

            return ticket;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Ticket findById(int id) {

        try {

            //initialisation du tableau 'arrayTicket' par le chargement de toutes les données en faisant un findAll()
            DAOFactory.getTicketDAO().findAll();

            //recherche du ticket dans le tableau par son id
            Ticket ticketFound = TicketDAO.arrayTicket.get(id);
            // récupération de l'année et du numéro de ticket
            int anneeTicket = ticketFound.getAnnee();
            int numTicket = ticketFound.getNumeroTicket();

            ResultSet resultStoredProcedure = StoredProcedure.procedureFindTicketById("{call findOneByNumTicket(?, ?)}", numTicket, anneeTicket);

            while (resultStoredProcedure.next()) {

                int annee = resultStoredProcedure.getInt("ANNEE");
                int numeroTicket = resultStoredProcedure.getInt("NUMERO_TICKET");
                java.sql.Date dateVenteSQL = resultStoredProcedure.getDate("DATE_VENTE");
                java.util.Date dateVente = new java.util.Date(dateVenteSQL.getTime());
                java.sql.Time heureVenteSQL = resultStoredProcedure.getTime("HEURE_VENTE");
                java.sql.Time heureVente = new java.sql.Time(heureVenteSQL.getTime());

                Ticket ticket = new Ticket(annee, numeroTicket, dateVente, heureVente);
                return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public Ticket update(Ticket ticket) {

        try {

            //java.sql.Date dateVente = new java.sql.Date(ticket.getDateVente().getTime());

            StoredProcedure.procedureUpdateTicket("{call updateTicket(?, ?, ?, ?)}",

                    ticket.getAnnee(),
                    ticket.getNumeroTicket(),
                    ticket.getDateVente(),
                    ticket.getHeureVente()

            );

            return ticket;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void delete(int id) {

        try {

            //initialisation du tableau 'arrayTicket' par le chargement de toutes les données en faisant un findAll()
            DAOFactory.getTicketDAO().findAll();

            //recherche du ticket dans le tableau par son id
            Ticket ticketFound = TicketDAO.arrayTicket.get(id);
            // récupération de l'année et du numéro de ticket
            int anneeTicket = ticketFound.getAnnee();
            int numTicket = ticketFound.getNumeroTicket();

            StoredProcedure.procedureDeleteTicket("{call deleteTicket(?, ?)}", numTicket, anneeTicket);

        } catch (SQLException e) {
            e.printStackTrace();

        }

    }


    public Map<Integer, Ticket> findAll() {

        int id = 1; // Initialisation de l'identifiant

        try {

            ResultSet resultSet = StoredProcedure.executeProcedure("{call findAllTicket()}");

            while (resultSet.next()) {

                int annee = resultSet.getInt("ANNEE");
                int numeroTicket = resultSet.getInt("NUMERO_TICKET");
                java.sql.Date dateVenteSQL = resultSet.getDate("DATE_VENTE");
                java.util.Date dateVente = new java.util.Date(dateVenteSQL.getTime());
                java.sql.Time heureVenteSQL = resultSet.getTime("HEURE_VENTE");
                java.sql.Time heureVente = new java.sql.Time(heureVenteSQL.getTime());

                Ticket ticket = new Ticket(annee, numeroTicket, dateVente, heureVente);

                arrayTicket.put(id++, ticket); // Utilisation de l'identifiant et incrémentation
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayTicket;
    }

}
