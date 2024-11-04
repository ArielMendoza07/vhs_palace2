package DAOs;

import DatabaseConnection.DatabaseConnection;
import vhs.palace.*;
import vhs.palace.Membresia;
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MembresiaDAO {
    public void crearMembresia(Membresia membresia) {
        String query = "INSERT INTO Membresia (usuario_id, fecha_inicio, fecha_fin, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, membresia.getUsuarioId());
            ps.setString(2, membresia.getFechaInicio());
            ps.setString(3, membresia.getFechaFin());
            ps.setString(4, membresia.getTipo());
            ps.executeUpdate();
            System.out.println("Membresía creada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al crear membresía: " + e.getMessage());
        }
    }

    public Membresia buscarMembresia(int membresiaId) {
        String query = "SELECT * FROM Membresia WHERE membresia_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, membresiaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Membresia(rs.getInt("membresia_id"), rs.getInt("usuario_id"), rs.getString("fecha_inicio"), rs.getString("fecha_fin"), rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar membresía: " + e.getMessage());
        }
        return null;
    }

    public void actualizarMembresia(Membresia membresia) {
        String query = "UPDATE Membresia SET usuario_id = ?, fecha_inicio = ?, fecha_fin = ?, tipo = ? WHERE membresia_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, membresia.getUsuarioId());
            ps.setString(2, membresia.getFechaInicio());
            ps.setString(3, membresia.getFechaFin());
            ps.setString(4, membresia.getTipo());
            ps.setInt(5, membresia.getMembresiaId());
            ps.executeUpdate();
            System.out.println("Membresía actualizada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar membresía: " + e.getMessage());
        }
    }

    public void eliminarMembresia(int membresiaId) {
        String query = "DELETE FROM Membresia WHERE membresia_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, membresiaId);
            ps.executeUpdate();
            System.out.println("Membresía eliminada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar membresía: " + e.getMessage());
        }
    }
}
