package com.DAC;


public class Equipement {
    private String nom;
    private String type;
    private int quantiteDisponible;
    private String conditionCritiqueRequise;
    private boolean flottable;
    private boolean enBonEtat;

    public Equipement(String nom, String type, int quantiteDisponible, String conditionCritiqueRequise, boolean flottable, boolean enBonEtat) {
        this.nom = nom;
        this.type = type;
        this.quantiteDisponible = quantiteDisponible;
        this.conditionCritiqueRequise = conditionCritiqueRequise;
        this.flottable = flottable;
        this.enBonEtat = enBonEtat;
    }

    public void verifierFonctionnementSousEau() {
        // Implémentation de la vérification du fonctionnement sous l'eau
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantiteDisponible() {
        return quantiteDisponible;
    }

    public void setQuantiteDisponible(int quantiteDisponible) {
        this.quantiteDisponible = quantiteDisponible;
    }

    public String getConditionCritiqueRequise() {
        return conditionCritiqueRequise;
    }

    public void setConditionCritiqueRequise(String conditionCritiqueRequise) {
        this.conditionCritiqueRequise = conditionCritiqueRequise;
    }

    public boolean isFlottable() {
        return flottable;
    }

    public void setFlottable(boolean flottable) {
        this.flottable = flottable;
    }

    public boolean isEnBonEtat() {
        return enBonEtat;
    }

    public void setEnBonEtat(boolean enBonEtat) {
        this.enBonEtat = enBonEtat;
    }

    
}

