package DAOs;

import DatabaseConnection.DatabaseConnection;
import vhs.palace.Transaccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransaccionDAO {

    public void crearTransaccion(Transaccion transaccion) {
        String query = "INSERT INTO Transaccion (usuario_id, fecha, total, estado, tipo, detalles_envio) VALUES (?, CURRENT_TIMESTAMP, ?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, transaccion.getUsuarioId());
            ps.setDouble(2, transaccion.getTotal());
            ps.setString(3, transaccion.getEstado());
            ps.setString(4, transaccion.getTipo());
            ps.setString(5, transaccion.getDetallesEnvio());
            ps.executeUpdate();
            System.out.println("Transacción registrada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar transacción: " + e.getMessage());
        }
    }

    public Transaccion buscarTransaccion(int transaccionId) {
        String query = "SELECT * FROM Transaccion WHERE transaccion_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, transaccionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Transaccion(
                        rs.getInt("transaccion_id"),
                        rs.getInt("usuario_id"),
                        rs.getString("fecha"),
                        rs.getDouble("total"),
                        rs.getString("estado"),
                        rs.getString("tipo"),
                        rs.getString("detalles_envio")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar transacción: " + e.getMessage());
        }
        return null;
    }

    public void actualizarTransaccion(Transaccion transaccion) {
        String query = "UPDATE Transaccion SET usuario_id = ?, total = ?, estado = ?, tipo = ?, detalles_envio = ? WHERE transaccion_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, transaccion.getUsuarioId());
            ps.setDouble(2, transaccion.getTotal());
            ps.setString(3, transaccion.getEstado());
            ps.setString(4, transaccion.getTipo());
            ps.setString(5, transaccion.getDetallesEnvio());
            ps.setInt(6, transaccion.getTransaccionId());
            ps.executeUpdate();
            System.out.println("Transacción actualizada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar transacción: " + e.getMessage());
        }
    }

    public void eliminarTransaccion(int transaccionId) {
        String query = "DELETE FROM Transaccion WHERE transaccion_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, transaccionId);
            ps.executeUpdate();
            System.out.println("Transacción eliminada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar transacción: " + e.getMessage());
        }
    }
}