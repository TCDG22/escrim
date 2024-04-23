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
    
    public void addEquipement(Objets equipement) {
        String query = "INSERT INTO Objets (designation, dlu, caisse_Id, quantite) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setString(1, equipement.getDesignation());
            ps.setDate(2, new java.sql.Date(equipement.getDlu().getTime()));
            ps.setInt(3, equipement.getCaisseId());
            ps.setInt(4, equipement.getQuantite());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Objets getObjetByID(int id) {
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

    public void updateEquipementQuantite(int id, int newQuantite) {
        String query = "UPDATE Objets SET quantite = ? WHERE objet_id = ?";
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setInt(1, newQuantite);
            ps.setInt(2, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating equipment failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
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
