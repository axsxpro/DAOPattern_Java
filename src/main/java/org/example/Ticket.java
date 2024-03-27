package org.example;

import java.util.Date;
import java.sql.Time;

public class Ticket {


    // Propriétés de la classe Ticket
    private int annee;
    private int numeroTicket;
    private Date dateVente;
    private Time heureVente;

    // Constructeur
    public Ticket(int annee, int numeroTicket, Date dateVente, Time heureVente) {

        this.annee = annee;
        this.numeroTicket = numeroTicket;
        this.dateVente = dateVente;
        this.heureVente = heureVente;
    }

    // Getters et Setters
    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Time getHeureVente() {
        return heureVente;
    }

    public void setHeureVente(Time heureVente) {
        this.heureVente = heureVente;
    }

    @Override
    public String toString() {
        return "Ticket {" +
                " annee=" + annee +
                ", numeroTicket=" + numeroTicket +
                ", dateVente=" + dateVente +
                ", heureVente=" + heureVente +
                '}';
    }


}