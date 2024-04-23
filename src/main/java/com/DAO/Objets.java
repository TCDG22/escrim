package com.DAO;

import java.util.Date;

public class Objets {
    private int objetId;
    private String designation;
    private int quantite;
    private Date dlu;
    private int caisseId;
    
    public int getObjetId() { return objetId; }
    public void setObjetId(int objetId) { this.objetId = objetId; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public Date getDlu() { return dlu; }
    public void setDlu(Date dlu) { this.dlu = dlu; }

    public int getCaisseId() { return caisseId; }
    public void setCaisseId(int caisseId) { this.caisseId = caisseId; }
}
