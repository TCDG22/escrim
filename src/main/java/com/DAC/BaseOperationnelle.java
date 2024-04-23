package com.DAC;

import java.util.List;

public class BaseOperationnelle {
    private String emplacement;
    private int capacite_dac;
    private List<Equipement> equipements;
    private boolean estOperationnelle;

    public BaseOperationnelle(String emplacement, int capacite_dac, List<Equipement> equipements) {
        this.emplacement = emplacement;
        this.equipements = equipements;
        this.estOperationnelle = true; 
        this.capacite_dac = capacite_dac; // Tous les lits sont disponibles initialement// Supposons que la base est opérationnelle par défaut
    }
    public void updateEquipements(int niveauInondation) {
        if (niveauInondation > 5) {
            this.equipements.add(new Equipement("Pompe haute puissance", "Urgence", niveauInondation, "Pour gestion des eaux hautes", estOperationnelle, estOperationnelle));
            this.equipements.add(new Equipement("Bateau gonflable", "Transport", niveauInondation, "Pour navigation en zone inondée", estOperationnelle, estOperationnelle));
        } else {
            this.equipements.add(new Equipement("Barrières anti-inondation", "Prévention", niveauInondation, "Pour contrôle des eaux basses", estOperationnelle, estOperationnelle));
        }
    }



    public void evaluerRisqueInondation() {
        // Implémentation de la logique d'évaluation du risque d'inondation
    }

    public void organiserEvacuation() {
        // Implémentation de la logique d'organisation d'évacuation
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public int getcapacite_dac() {
        return capacite_dac
;
    }

    public void setcapacite_dac(int capacite_dac) {
        this.capacite_dac
 = capacite_dac
;
    }

    public List<Equipement> getEquipements() {
        return equipements;
    }

    public void setEquipements(List<Equipement> equipements) {
        this.equipements = equipements;
    }

    public boolean isEstOperationnelle() {
        return estOperationnelle;
    }

    public void setEstOperationnelle(boolean estOperationnelle) {
        this.estOperationnelle = estOperationnelle;
    }
    
}

