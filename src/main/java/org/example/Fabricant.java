package org.example;


public class Fabricant {


    // Propriétés de la classe Fabricant
    private int idFabricant;
    private String nomFabricant;

    // Constructeur
    public Fabricant(int idFabricant, String nomFabricant) {
        this.idFabricant = idFabricant;
        this.nomFabricant = nomFabricant;
    }

    // Getters et Setters
    public int getIdFabricant() {
        return idFabricant;
    }

    public void setIdFabricant(int idFabricant) {
        this.idFabricant = idFabricant;
    }

    public String getNomFabricant() {
        return nomFabricant;
    }

    public void setNomFabricant(String nomFabricant) {
        this.nomFabricant = nomFabricant;
    }

    @Override
    public String toString() {
        return "ID fabricant: " + idFabricant + ", Nom fabricant: " + nomFabricant;
    }

}
