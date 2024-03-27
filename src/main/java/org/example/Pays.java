package org.example;


public class Pays {


    // Propriétés de la classe Pays
    private int idPays;
    private String nomPays;

    private Continent idContinent;

    // Constructeur
    public Pays(int idPays, String nomPays, Continent idContinent) {
        this.idPays = idPays;
        this.nomPays = nomPays;
        this.idContinent = idContinent;
    }

    // Getters et Setters
    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public Continent getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(Continent continent) {
        this.idContinent = continent;
    }

    @Override
    public String toString() {
        return "ID pays: " + idPays + ", Nom pays: " + nomPays + ", " + idContinent;
    }


}