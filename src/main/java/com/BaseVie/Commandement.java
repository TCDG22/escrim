package com.BaseVie;

import com.DAC.*;
import com.DAHMO.*;

import java.util.ArrayList;
import java.util.List;

public class Commandement {
    public static final int CONFIGURATION_BASE = 1;
    public static final int CONFIGURATION_COMPLETE = 2;
    private BaseOperationnelle dac;
    private Hospitalisation dahmo;
    List<Equipement> equipements = new ArrayList<>();

    public Commandement() {
        // La configuration initiale peut être définie ici ou passée via un setter ou lors de la création d'une instance
    }
    public void rapporterInondation(int niveauInondation) {
        dac.updateEquipements(niveauInondation);
        dahmo.updateEquipements(niveauInondation);
    }

    public void deployer(int configuration) {
        int litsDAC, litsDAMHO;
        switch (configuration) {
            case CONFIGURATION_BASE:
                litsDAC = 12;
                litsDAMHO = 42;
                break;
            case CONFIGURATION_COMPLETE:
                litsDAC = 20;
                litsDAMHO = 80;
                break;
            default:
                throw new IllegalArgumentException("Configuration non valide.");
        }
        dac = new BaseOperationnelle("Emplacement DAC", litsDAC, equipements);
        dahmo = new Hospitalisation("Emplacement DAMHO", litsDAMHO, equipements);
    }
    
}

