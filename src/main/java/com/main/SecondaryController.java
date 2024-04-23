package com.main;

import java.sql.Date;

import com.DAO.Caisse;
import com.DAO.CaisseDAO;
import com.DAO.Medicaments;
import com.DAO.MedicamentsDAO;
import com.DAO.Objets;
import com.DAO.ObjetsDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;

public class SecondaryController {
    @FXML
    private Button delButton;
    @FXML
    private Button addCaisseButton;
    @FXML
    private TextField newAffectataire;
    @FXML
    private TextField newCondition;
    @FXML
    private TextField newDesignation;
    @FXML
    private TextField newDimension;
    @FXML
    private TextField newIata;
    @FXML
    private TextField newModule;
    @FXML
    private TextField newNature;
    @FXML
    private TextField newObservation;
    @FXML
    private TextField newPoids;
    @FXML
    private TextField newPrecision;
    @FXML
    private TextField newProjection;
    @FXML
    private TextField newSecteur;
    @FXML
    private TextField newValeur;
    @FXML
    private TextField newVolume;
    @FXML
    private TextField upID;
    @FXML
    private TextField delID;
    @FXML
    private TextField upSecteur;    
    @FXML
    private TextField upObservation;  
    @FXML
    private TextField newMedCaisse;
    @FXML
    private TextField newMedClasse;
    @FXML
    private TextField newMedDCI;
    @FXML
    private TextField newMedDLU;
    @FXML
    private TextField newMedForme;
    @FXML
    private TextField newMedIDCaisse;
    @FXML
    private TextField newMedLot;
    @FXML
    private TextField newMedProduit;
    @FXML
    private TextField newMedQuantite;
    @FXML
    private TextField newMedU7;
    @FXML
    private TextField delMedID;
    @FXML
    private TextField upMedID;
    @FXML
    private TextField upMedStock;  
    @FXML
    private TableColumn<Caisse, Integer> caisseN;
    @FXML
    private TableColumn<Caisse, String> caisseAffectataire;
    @FXML
    private TableColumn<Caisse, String> caisseDesignation;
    @FXML
    private TableColumn<Caisse, String> caisseDim;
    @FXML
    private TableColumn<Caisse, String> caisseIata;
    @FXML
    private TableColumn<Caisse, String> caisseModule;
    @FXML
    private TableColumn<Caisse, String> caisseNature;
    @FXML
    private TableColumn<Caisse, String> caisseNominal;
    @FXML
    private TableColumn<Caisse, String> caisseObservation;
    @FXML
    private TableColumn<Caisse, Integer> caissePoids;
    @FXML
    private TableColumn<Caisse, String> caissePrecision;
    @FXML
    private TableColumn<Caisse, String> caisseProjection;
    @FXML
    private TableColumn<Caisse, String> caisseSecteur;
    @FXML
    private TableColumn<Caisse, String> caisseValeur;
    @FXML
    private TableColumn<Caisse, Float> caisseVol;
    @FXML
    private TableView<Caisse> caisseTab;    
    @FXML
    private TableColumn<Objets, Date> equipDLU;
    @FXML
    private TableColumn<Objets, String> equipDesignation;
    @FXML
    private TableColumn<Objets, Integer> equipN;
    @FXML
    private TableColumn<Objets, Integer> equipNCaisse;
    @FXML
    private TableColumn<Objets, Integer> equipQuantite;
    @FXML
    private TableView<Objets> equipTab;
    @FXML
    private TableColumn<Medicaments, String> medCaisse;
    @FXML
    private TableColumn<Medicaments, String> medClasse;
    @FXML
    private TableColumn<Medicaments, String> medDCI;
    @FXML
    private TableColumn<Medicaments, Date> medDLU;
    @FXML
    private TableColumn<Medicaments, String> medForme;
    @FXML
    private TableColumn<Medicaments, String> medLot;
    @FXML
    private TableColumn<Medicaments, Integer> medN;
    @FXML
    private TableColumn<Medicaments, Integer> medNCaisse;
    @FXML
    private TableColumn<Medicaments, String> medNom;
    @FXML
    private TableColumn<Medicaments, Integer> medStock;
    @FXML
    private TableColumn<Medicaments, String> medU7;
    @FXML
    private TableView<Medicaments> medTab;
    @FXML
    private TextField newEqDLU;
    @FXML
    private TextField newEqDesignation;
    @FXML
    private TextField newEqNCaisse;
    @FXML
    private TextField newEqQuantite;
    @FXML
    private TextField delEqID;
    @FXML
    private TextField upEqID;
    @FXML
    private TextField upEqQuantite;

    @FXML
    public void initialize() {
        caisseN.setCellValueFactory(new PropertyValueFactory<>("idCaisse"));
        caisseAffectataire.setCellValueFactory(new PropertyValueFactory<>("affectataire"));
        caisseDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        caisseDim.setCellValueFactory(new PropertyValueFactory<>("dimension"));
        caisseIata.setCellValueFactory(new PropertyValueFactory<>("iata"));
        caisseModule.setCellValueFactory(new PropertyValueFactory<>("module"));
        caisseNature.setCellValueFactory(new PropertyValueFactory<>("nature"));
        caisseNominal.setCellValueFactory(new PropertyValueFactory<>("condition"));
        caisseObservation.setCellValueFactory(new PropertyValueFactory<>("observation"));
        caissePoids.setCellValueFactory(new PropertyValueFactory<>("poids"));
        caissePrecision.setCellValueFactory(new PropertyValueFactory<>("precision"));
        caisseProjection.setCellValueFactory(new PropertyValueFactory<>("projection"));
        caisseSecteur.setCellValueFactory(new PropertyValueFactory<>("secteur"));
        caisseValeur.setCellValueFactory(new PropertyValueFactory<>("valeur"));
        caisseVol.setCellValueFactory(new PropertyValueFactory<>("volume"));
        loadCaisseData();
    
        medN.setCellValueFactory(new PropertyValueFactory<>("idMedicaments"));
        medNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        medDCI.setCellValueFactory(new PropertyValueFactory<>("dci"));
        medForme.setCellValueFactory(new PropertyValueFactory<>("forme"));
        medDLU.setCellValueFactory(new PropertyValueFactory<>("dlu"));
        medStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        medLot.setCellValueFactory(new PropertyValueFactory<>("lot"));
        medClasse.setCellValueFactory(new PropertyValueFactory<>("classeTherapeutique"));
        medCaisse.setCellValueFactory(new PropertyValueFactory<>("caisse"));
        medU7.setCellValueFactory(new PropertyValueFactory<>("u7"));
        medNCaisse.setCellValueFactory(new PropertyValueFactory<>("caisseId"));
        loadMedicamentsData();
    
        equipN.setCellValueFactory(new PropertyValueFactory<>("objetId"));
        equipDesignation.setCellValueFactory(new PropertyValueFactory<>("designation"));
        equipQuantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        equipDLU.setCellValueFactory(new PropertyValueFactory<>("dlu"));
        equipNCaisse.setCellValueFactory(new PropertyValueFactory<>("caisseId"));
        loadObjetsData();
    }

    @FXML
    void addEq(ActionEvent event) {
        Objets newEquipement = new Objets();
        newEquipement.setDesignation(newEqDesignation.getText());
        try {
            newEquipement.setDlu(Date.valueOf(newEqDLU.getText()));
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid format for Date: " + e.getMessage());
            return;
        }
        newEquipement.setCaisseId(Integer.parseInt(newEqNCaisse.getText()));
        newEquipement.setQuantite(Integer.parseInt(newEqQuantite.getText()));
    
        ObjetsDAO objetsDAO = new ObjetsDAO();
        objetsDAO.addEquipement(newEquipement);
    
        loadObjetsData();
    }
    
    
    @FXML
    void addCaisse(ActionEvent event) {
        Caisse newCaisse = new Caisse();
        newCaisse.setAffectataire(newAffectataire.getText());
        newCaisse.setModule(newModule.getText());
        newCaisse.setCondition(newCondition.getText());
        newCaisse.setSecteur(newSecteur.getText());
        newCaisse.setNature(newNature.getText());
        newCaisse.setDesignation(newDesignation.getText());
        newCaisse.setPrecision(newPrecision.getText());
        newCaisse.setDimension(newDimension.getText());
        newCaisse.setValeur(newValeur.getText());
        try {
            newCaisse.setVolume(Float.parseFloat(newVolume.getText()));
            newCaisse.setPoids(Integer.parseInt(newPoids.getText()));
        } catch (NumberFormatException e) {
            System.err.println("Erreur valeurs numériques: " + e.getMessage());
            return;
        }
        newCaisse.setObservation(newObservation.getText());
        newCaisse.setIata(newIata.getText());
        newCaisse.setProjection(newProjection.getText());
    
        CaisseDAO caisseDAO = new CaisseDAO();
        caisseDAO.addCaisse(newCaisse);
    
        clearCaisseForm();
    
        loadCaisseData();
    }


    @FXML
    void upCaisse(ActionEvent event) {
        try {
            int id = Integer.parseInt(upID.getText());
            String observation = upObservation.getText();
            String secteur = upSecteur.getText();
    
            CaisseDAO caisseDAO = new CaisseDAO();
    
            if (!observation.isEmpty()) {
                caisseDAO.updateCaisseObservation(id, observation);
            }
    
            if (!secteur.isEmpty()) {
                caisseDAO.updateCaisseSecteur(id, secteur);
            }
    
            upID.clear();
            upObservation.clear();
            upSecteur.clear();
    
            loadCaisseData();
        } catch (NumberFormatException e) {
            System.err.println("Numéro incorrect: " + e.getMessage());
        }
    }

    @FXML
    void delEq(ActionEvent event) {
        try {
            int id = Integer.parseInt(delEqID.getText());
            ObjetsDAO objetsDAO = new ObjetsDAO();
            objetsDAO.deleteObjet(id);

            delEqID.clear();
    
            loadObjetsData();
        } catch (NumberFormatException e) {
            System.err.println("Numéro incorrect: " + e.getMessage());
        }
    }

    @FXML
    void delCaisse(ActionEvent event) {
        try {
            int id = Integer.parseInt(delID.getText());
            CaisseDAO caisseDAO = new CaisseDAO();
            caisseDAO.deleteCaisse(id);

            delID.clear();
    
            loadCaisseData();
        } catch (NumberFormatException e) {
            System.err.println("Numéro incorrect: " + e.getMessage());
        }
    }

    @FXML
    void delMed(ActionEvent event) {
        try {
            int id = Integer.parseInt(delMedID.getText());
            MedicamentsDAO medicamentsDAO = new MedicamentsDAO();
            medicamentsDAO.deleteMedicament(id);

            delMedID.clear();
    
            loadMedicamentsData();
        } catch (NumberFormatException e) {
            System.err.println("Numéro incorrect: " + e.getMessage());
        }
    }

    @FXML
    void upMed(ActionEvent event) {
        try {
            int medicamentId = Integer.parseInt(upMedID.getText());
            int newStock = Integer.parseInt(upMedStock.getText());
    
            MedicamentsDAO medicamentsDAO = new MedicamentsDAO();
            medicamentsDAO.updateMedicamentStock(medicamentId, newStock);
    
            upMedID.clear();
            upMedStock.clear();
    
            loadMedicamentsData();
        } catch (NumberFormatException e) {
            System.err.println("Numéro incorrect: " + e.getMessage());
        }
    }

    @FXML
    void upEq(ActionEvent event) {
        try {
            int equipementId = Integer.parseInt(upEqID.getText());
            int newQuantite = Integer.parseInt(upEqQuantite.getText());
    
            ObjetsDAO objetsDAO = new ObjetsDAO();
            objetsDAO.updateEquipementQuantite(equipementId, newQuantite);
    
            upEqID.clear();
            upEqQuantite.clear();
    
            loadObjetsData();
        } catch (NumberFormatException e) {
            System.err.println("Numéro incorrect: " + e.getMessage());
        }
    }

    @FXML
    void addMed(ActionEvent event) {
        Medicaments newMedicament = new Medicaments();
        newMedicament.setNom(newMedProduit.getText());
        newMedicament.setDci(newMedDCI.getText());
        newMedicament.setForme(newMedForme.getText());
        try {
            newMedicament.setDlu(Date.valueOf(newMedDLU.getText()));
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid format for Date: " + e.getMessage());
            return;
        }
        newMedicament.setStock(Integer.parseInt(newMedQuantite.getText()));
        newMedicament.setLot(newMedLot.getText());
        newMedicament.setClasseTherapeutique(newMedClasse.getText());
        newMedicament.setCaisse(newMedCaisse.getText());
        newMedicament.setU7(newMedU7.getText());
        newMedicament.setCaisseId(Integer.parseInt(newMedIDCaisse.getText()));
    
        MedicamentsDAO medicamentsDAO = new MedicamentsDAO();
        medicamentsDAO.addMedicament(newMedicament);
    
        loadMedicamentsData();
    }
    
    private void clearCaisseForm() {
        newAffectataire.clear();
        newCondition.clear();
        newDesignation.clear();
        newDimension.clear();
        newIata.clear();
        newModule.clear();
        newNature.clear();
        newObservation.clear();
        newPoids.clear();
        newPrecision.clear();
        newProjection.clear();
        newSecteur.clear();
        newValeur.clear();
        newVolume.clear();
    }

    private void loadCaisseData() {
        ObservableList<Caisse> caisses = FXCollections.observableArrayList();
        CaisseDAO caisseDAO = new CaisseDAO();
        caisses.addAll(caisseDAO.getAllCaisses());
        caisseTab.setItems(caisses);
    }
    
    private void loadMedicamentsData() {
        ObservableList<Medicaments> medicaments = FXCollections.observableArrayList();
        MedicamentsDAO medicamentsDAO = new MedicamentsDAO();
        medicaments.addAll(medicamentsDAO.getAllMedicaments());
        medTab.setItems(medicaments);
    }
    
    private void loadObjetsData() {
        ObservableList<Objets> objets = FXCollections.observableArrayList();
        ObjetsDAO objetsDAO = new ObjetsDAO();
        objets.addAll(objetsDAO.getAllObjets());
        equipTab.setItems(objets);
    }

}