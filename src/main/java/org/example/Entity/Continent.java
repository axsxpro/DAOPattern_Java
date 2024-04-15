package org.example.Entity;


public class Continent {


    // Propriétés de la classe Continent
    private int idContinent;
    private String nomContinent;

    // Constructeur
    public Continent(int idContinent, String nomContinent) {
        this.idContinent = idContinent;
        this.nomContinent = nomContinent;
    }

    // Getters et Setters
    public int getIdContinent() {
        return idContinent;
    }

    public void setIdContinent(int idContinent) {
        this.idContinent = idContinent;
    }

    public String getNomContinent() {
        return nomContinent;
    }

    public void setNomContinent(String nomContinent) {
        this.nomContinent = nomContinent;
    }

    @Override
    public String toString() {
        return "ID continent: " + idContinent + ", Nom continent: " + nomContinent;
    }

}
