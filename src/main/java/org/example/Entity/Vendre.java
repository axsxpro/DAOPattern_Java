package org.example.Entity;


public class Vendre {

    private int annee;
    private int numeroTicket;
    private Article idArticle;
    private int quantite;
    private float prixVente;

    public Vendre(int annee, int numeroTicket, Article idArticle, int quantite, float prixVente) {

        this.annee = annee;
        this.numeroTicket = numeroTicket;
        this.idArticle = idArticle;
        this.quantite = quantite;
        this.prixVente = prixVente;
    }

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

    public Article getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Article idArticle) {
        this.idArticle = idArticle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    @Override
    public String toString() {
        return "Vente {" +
                " annee=" + annee +
                ", numeroTicket=" + numeroTicket +
                ", idArticle=" + idArticle +
                ", quantite=" + quantite +
                ", prixVente=" + prixVente +
                '}';
    }
}