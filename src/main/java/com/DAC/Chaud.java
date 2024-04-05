package com.DAC;

public class Chaud extends ConfigurationClimatique{
    private int niveauHydratationRequis;

    public Chaud(int niveauHydratationRequis) {
        super("Chaud");
        this.niveauHydratationRequis = niveauHydratationRequis;
    }

    @Override
    public void adapterEquipement() {
        
    }
}
