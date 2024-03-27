package org.example;


public class Couleur {

    // Propriétés de la classe Couleur
    private int idCouleur;
    private String nomCouleur;

    // Constructeur
    public Couleur(int idCouleur, String nomCouleur) {
        this.idCouleur = idCouleur;
        this.nomCouleur = nomCouleur;
    }

    // Getters et Setters
    public int getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    @Override
    public String toString() {
        return "ID couleur: " + idCouleur + ", Nom couleur: " + nomCouleur;
    }

}
