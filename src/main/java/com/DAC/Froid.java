package com.DAC;

public class Froid extends ConfigurationClimatique{
    private int niveauIsolationRequis;

    public Froid(int niveauIsolationRequis) {
        super("Froid");
        this.niveauIsolationRequis = niveauIsolationRequis;
    }

    @Override
    public void adapterEquipement() {
        
    }
}
