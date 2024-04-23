package com.DAHMO;

import java.util.ArrayList;
import java.util.List;
import com.DAC.*;

public class Hospitalisation {
    private int idHospitalisation;
    private int capacite_dahmo;
    private List<Patient> patients;
    private List<Equipement> equipements;



    public Hospitalisation(String emplacement, int capacite_dahmo, List<Equipement> equipements) {
        this.capacite_dahmo = capacite_dahmo;
        this.patients = new ArrayList<>();
    }
    public void admettrePatient(Patient patient) {
		int index = patients.indexOf(patient);
        if (index < capacite_dahmo) {
            patients.add(patient);
        } else {
            System.out.println("Le patient ne peut pas être pris en charge en bloc (dahmo)");
        }
    }

    public void evacuerPatient(String nomPatient) {
        boolean isRemoved =patients.removeIf(patient -> patient.getNom().equals(nomPatient));
        if(isRemoved) {
            System.out.println("Le patient est sorti de la dahmo");
        } else {
            System.out.println("Le patient n'a pas été trouvé");
        }
    }
    public void updateEquipements(int niveauInondation) {
        if (niveauInondation > 5) {
            this.equipements.add(new Equipement("Pompe haute puissance", "Urgence", niveauInondation, "Pour gestion des eaux hautes", false, false));
            this.equipements.add(new Equipement("Bateau gonflable", "Transport", niveauInondation, "Pour navigation en zone inondée", false, false));
        } else {
            this.equipements.add(new Equipement("Barrières anti-inondation", "Prévention", niveauInondation, "Pour contrôle des eaux basses", false, false));
        }
    }

    public int getIdHospitalisation() {
        return idHospitalisation;
    }

    public void setIdHospitalisation(int idHospitalisation) {
        this.idHospitalisation = idHospitalisation;
    }

    public int getcapacite_dahmo() {
        return capacite_dahmo;
    }

    public void setcapacite_dahmo(int capacite_dahmo) {
        this.capacite_dahmo = capacite_dahmo;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

}