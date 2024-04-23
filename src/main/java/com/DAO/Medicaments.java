package com.DAO;

import java.util.Date;

public class Medicaments {
    private int idMedicaments;
    private String nom;
    private String dci;
    private String forme;
    private Date dlu;
    private int stock;
    private String lot;
    private String classeTherapeutique;
    private String caisse;
    private String u7;
    private int caisseId;
    
    public int getIdMedicaments() {
        return idMedicaments;
    }

    public String getNom() {
        return nom;
    }

    public String getDci() {
        return dci;
    }

    public String getForme() {
        return forme;
    }

    public Date getDlu() {
        return dlu;
    }

    public int getStock() {
        return stock;
    }

    public String getLot() {
        return lot;
    }

    public String getClasseTherapeutique() {
        return classeTherapeutique;
    }

    public String getCaisse() {
        return caisse;
    }

    public String getU7() {
        return u7;
    }

    public int getCaisseId() {
        return caisseId;
    }
    
    public void setIdMedicaments(int idMedicaments) {
        this.idMedicaments = idMedicaments;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDci(String dci) {
        this.dci = dci;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }

    public void setDlu(Date dlu) {
        this.dlu = dlu;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public void setClasseTherapeutique(String classeTherapeutique) {
        this.classeTherapeutique = classeTherapeutique;
    }

    public void setCaisse(String caisse) {
        this.caisse = caisse;
    }

    public void setU7(String u7) {
        this.u7 = u7;
    }

    public void setCaisseId(int caisseId) {
        this.caisseId = caisseId;
    }
}
