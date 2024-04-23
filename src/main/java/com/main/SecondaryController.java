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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.fxml.FXML;

public class SecondaryController {
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