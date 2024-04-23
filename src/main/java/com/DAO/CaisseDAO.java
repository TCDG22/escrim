package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CaisseDAO {
    private Connection dbConnection;

    public CaisseDAO() {
        dbConnection = DBConnection.getConnection();
    }
    
    public List<Caisse> getAllCaisses() {
        List<Caisse> caisses = new ArrayList<>();
        String query = "SELECT * FROM Caisse";
        try (PreparedStatement ps = dbConnection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Caisse caisse = new Caisse();
                caisse.setIdCaisse(rs.getInt("Id_caisse"));
                caisse.setAffectataire(rs.getString("Affectataire"));
                caisse.setModule(rs.getString("Module"));
                caisse.setCondition(rs.getString("Condition"));
                caisse.setSecteur(rs.getString("Secteur"));
                caisse.setNature(rs.getString("Nature"));
                caisse.setDesignation(rs.getString("Désignation"));
                caisse.setPrecision(rs.getString("Précision"));
                caisse.setDimension(rs.getString("Dimension"));
                caisse.setVolume(rs.getFloat("Volume"));
                caisse.setPoids(rs.getInt("Poids"));
                caisse.setObservation(rs.getString("Observation"));
                caisses.add(caisse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caisses;
    }

    public void addCaisse(Caisse caisse) {
        String query = "INSERT INTO Caisse (Affectataire, Module, Condition, Secteur, Nature, Désignation, Précision, Dimension, Volume, Poids, Observation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, caisse.getAffectataire());
            // Continuer pour tous les paramètres...
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Caisse getCaisse(int id) {
        Caisse caisse = null;
        String query = "SELECT * FROM Caisse WHERE Id_caisse = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                caisse = new Caisse();            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caisse;
    }
    
    // public void updateCaisse(Caisse caisse) {
    //     String query = "UPDATE Caisse SET Affectataire=?, Module=?, ... WHERE Id_caisse=?";
    //     try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
    //         ps.setString(1, caisse.getAffectataire());
    //         // Continuer pour tous les champs...
    //         ps.setInt(/* dernier indice */, caisse.getIdCaisse());
    //         ps.executeUpdate();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    public void deleteCaisse(int id) {
        String query = "DELETE FROM Caisse WHERE Id_caisse = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
