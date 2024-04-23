package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentsDAO {
    private Connection dbConnection;

    public MedicamentsDAO() {
        dbConnection = DBConnection.getConnection();
    }

    public List<Medicaments> getAllMedicaments() {
        List<Medicaments> medicamentsList = new ArrayList<>();
        String query = "SELECT * FROM Medicaments";
        try (PreparedStatement ps = dbConnection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Medicaments medicament = new Medicaments();
                medicament.setIdMedicaments(rs.getInt("id_medicament"));
                medicament.setNom(rs.getString("nom"));
                medicament.setDci(rs.getString("dci"));
                medicament.setForme(rs.getString("forme"));
                medicament.setDlu(rs.getDate("dlu"));
                medicament.setStock(rs.getInt("stock"));
                medicament.setLot(rs.getString("lot"));
                medicament.setClasseTherapeutique(rs.getString("classe_Therapeutique"));
                medicament.setCaisse(rs.getString("caisse"));
                medicament.setU7(rs.getString("u7"));
                medicament.setCaisseId(rs.getInt("caisse_Id"));
                medicamentsList.add(medicament);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamentsList;
    }

    public void addMedicament(Medicaments medicament) {
        String query = "INSERT INTO Medicaments (nom, dci, forme, dlu, stock, lot, classe_Therapeutique, caisse, u7, caisse_Id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setString(1, medicament.getNom());
            ps.setString(2, medicament.getDci());
            ps.setString(3, medicament.getForme());
            ps.setDate(4, new java.sql.Date(medicament.getDlu().getTime()));
            ps.setInt(5, medicament.getStock());
            ps.setString(6, medicament.getLot());
            ps.setString(7, medicament.getClasseTherapeutique());
            ps.setString(8, medicament.getCaisse());
            ps.setString(9, medicament.getU7());
            ps.setInt(10, medicament.getCaisseId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Medicaments getMedicamentById(int id) {
        Medicaments medicament = null;
        String query = "SELECT * FROM Medicaments WHERE Id_medicaments = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medicament = new Medicaments();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicament;
    }
    
    public void updateMedicamentStock(int id, int newStock) {
        String query = "UPDATE Medicaments SET stock = ? WHERE id_Medicament = ?";
        try (PreparedStatement ps = dbConnection.prepareStatement(query)) {
            ps.setInt(1, newStock);
            ps.setInt(2, id);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating medicament failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteMedicament(int id) {
        String query = "DELETE FROM Medicaments WHERE Id_medicament = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
