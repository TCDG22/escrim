package com.DAC;

import java.util.List;

public class BaseOperationnelle {
    public String emplacement;
    public enum etatOperationnel {dormance, actif};
    public int capacite;
    public List<Equipement> equipementDisponible;
}

