package org.example;


public class Marque {


    // Propriétés de la classe Marque
    private int idMarque;
    private String nomMarque;
    private Pays idPays;
    private Fabricant idFabricant;

    // Constructeur
    public Marque(int idMarque, String nomMarque, Pays idPays, Fabricant idFabricant) {

        this.idMarque = idMarque;
        this.nomMarque = nomMarque;
        this.idPays = idPays;
        this.idFabricant = idFabricant;
    }

    // Getters et Setters
    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public  Pays getIdPays() {
        return idPays;
    }

    public void setIdPays(Pays idPays) {
        this.idPays = idPays;
    }

    public Fabricant getIdFabricant() {
        return idFabricant;
    }

    public void setIdFabricant(Fabricant idFabricant) {
        this.idFabricant = idFabricant;
    }

    @Override
    public String toString() {
        return "ID marque: " + idMarque + ", Nom marque: " + nomMarque + ", " + idPays + ", " + idFabricant;
    }
}