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
        try (PreparedStatement ps = dbConnection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, caisse.getAffectataire());
            ps.setString(2, caisse.getModule());
            ps.setString(3, caisse.getCondition());
            ps.setString(4, caisse.getSecteur());
            ps.setString(5, caisse.getNature());
            ps.setString(6, caisse.getDesignation());
            ps.setString(7, caisse.getPrecision());
            ps.setString(8, caisse.getDimension());
            ps.setFloat(9, caisse.getVolume());
            ps.setInt(10, caisse.getPoids());
            ps.setString(11, caisse.getObservation());
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating caisse failed, no rows affected.");
            }

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    caisse.setIdCaisse(generatedKeys.getInt(1)); // Assuming you have a setter for ID if you need to use it later
                } else {
                    throw new SQLException("Creating caisse failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        

    public Caisse getCaisseById(int id) {
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

    public void updateCaisseObservation(int idCaisse, String newObservation) {
        String query = "UPDATE Caisse SET Observation = ? WHERE Id_caisse = ?";
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setString(1, newObservation);
            ps.setInt(2, idCaisse);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating caisse failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCaisseSecteur(int idCaisse, String newSecteur) {
        String query = "UPDATE Caisse SET Secteur = ? WHERE Id_caisse = ?";
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setString(1, newSecteur);
            ps.setInt(2, idCaisse);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating caisse failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
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
