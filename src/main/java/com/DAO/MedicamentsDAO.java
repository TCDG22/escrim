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
        String query = "INSERT INTO Medicaments (Nom, DCI, Forme, DLU, Stock, Lot, Classe_therapeutique, Caisse, U7, Caisse_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setString(1, medicament.getNom());
            // Continuer pour tous les paramètres...
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Medicaments getMedicament(int id) {
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
    
    // public void updateMedicament(Medicaments medicament) {
    //     String query = "UPDATE Medicaments SET Nom=?, DCI=?, ... WHERE Id_medicaments=?";
    //     try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
    //         ps.setString(1, medicament.getNom());
    //         // Continuer pour tous les champs...
    //         ps.setInt(/* dernier indice */, medicament.getIdMedicaments());
    //         ps.executeUpdate();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    public void deleteMedicament(int id) {
        String query = "DELETE FROM Medicaments WHERE Id_medicaments = ?";
        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
