package org.example.Entity;


public class Article {

    private int idArticle;
    private String nomArticle;
    private float prixAchat;
    private int volume;
    private float titrage;
    private Marque idMarque;
    private Couleur idCouleur;
    private TypeBiere idType;


    // Constructeur
    public Article(int idArticle, String nomArticle, float prixAchat, int volume, float titrage, Marque idMarque, Couleur idCouleur, TypeBiere idType) {
        this.idArticle = idArticle;
        this.nomArticle = nomArticle;
        this.prixAchat = prixAchat;
        this.volume = volume;
        this.titrage = titrage;
        this.idMarque = idMarque;
        this.idCouleur = idCouleur;
        this.idType = idType;
    }

    // Getters et Setters
    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public float getTitrage() {
        return titrage;
    }

    public void setTitrage(float titrage) {
        this.titrage = titrage;
    }

    public Marque getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(Marque marque) {
        this.idMarque = marque;
    }

    public Couleur getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(Couleur couleur) {
        this.idCouleur = couleur;
    }

    public TypeBiere getIdType() {
        return idType;
    }

    public void setIdType(TypeBiere type) {
        this.idType = type;
    }


    @Override
    public String toString() {

        return  "{" +

                "idArticle=" + idArticle +
                ", nomArticle='" + nomArticle + '\'' +
                ", prixAchat=" + prixAchat +
                ", volume=" + volume +
                ", titrage=" + titrage +
                ", "+ idMarque +
                ", "+ idCouleur +
                ", " +idType +

                '}';
    }


}
