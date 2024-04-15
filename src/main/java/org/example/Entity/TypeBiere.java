package org.example.Entity;


public class TypeBiere {

    private int idType;
    private String nomType;


    //constructeur
    public TypeBiere(int idType, String nomType) {
        this.idType = idType;
        this.nomType = nomType;
    }


    // Getters et Setters
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String nomType) {
        this.nomType = nomType;
    }

    @Override
    public String toString() {
        return "ID type: " + idType + ", Nom Marque: " + nomType;
    }

}
