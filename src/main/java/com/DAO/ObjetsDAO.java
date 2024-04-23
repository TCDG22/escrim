package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetsDAO {
    private Connection dbConnection;

    public ObjetsDAO() {
        dbConnection = DBConnection.getConnection();
    }
    
    public List<Objets> getAllObjets() {
        List<Objets> objetsList = new ArrayList<>();
        String query = "SELECT * FROM Objets";
        try (PreparedStatement ps = dbConnection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Objets objet = new Objets();
                objet.setObjetId(rs.getInt("Objet_id"));
                objet.setDesignation(rs.getString("Designation"));
                objet.setQuantite(rs.getInt("Quantite"));
                objet.setDlu(rs.getDate("Dlu"));
                objet.setCaisseId(rs.getInt("Caisse_id"));
                objetsList.add(objet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objetsList;
    }
    
    public void addObjet(Objets objet) {
        String query = "INSERT INTO Objets (Designation, Quantite, DLU, Caisse_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, objet.getDesignation());
            // Continuer pour tous les paramètres...
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Objets getObjet(int id) {
        Objets objet = null;
        String query = "SELECT * FROM Objets WHERE Objet_id = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                objet = new Objets();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objet;
    }
    
    // public void updateObjet(Objets objet) {
    //     String query = "UPDATE Objets SET Designation=?, Quantite=?, ... WHERE Objet_id=?";
    //     try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
    //         ps.setString(1, objet.getDesignation());
    //         // Continuer pour tous les champs...
    //         ps.setInt(/* dernier indice */, objet.getObjetId());
    //         ps.executeUpdate();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    public void deleteObjet(int id) {
        String query = "DELETE FROM Objets WHERE Objet_id = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
