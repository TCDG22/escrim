package com.DAC;

public abstract class ConfigurationClimatique {
    protected String typeClimat;

    public ConfigurationClimatique(String typeClimat) {
        this.typeClimat = typeClimat;
    }

    public abstract void adapterEquipement();
}
