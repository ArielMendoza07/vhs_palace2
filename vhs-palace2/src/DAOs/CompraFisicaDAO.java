package DAOs;

import DatabaseConnection.DatabaseConnection;
import vhs.palace.CompraFisica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraFisicaDAO {
    public void registrarCompra(CompraFisica compraFisica) {
        String query = "INSERT INTO CompraFisica (usuario_id, nombre_completo, direccion, ciudad, estado, codigo_postal, numero_tarjeta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, compraFisica.getUsuarioId());
            ps.setString(2, compraFisica.getNombreCompleto());
            ps.setString(3, compraFisica.getDireccion());
            ps.setString(4, compraFisica.getCiudad());
            ps.setString(5, compraFisica.getEstado());
            ps.setString(6, compraFisica.getCodigoPostal());
            ps.setString(7, compraFisica.getNumeroTarjeta());
            ps.executeUpdate();
            System.out.println("Compra registrada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al registrar compra: " + e.getMessage());
        }
    }

    public CompraFisica buscarCompra(int compraId) {
        String query = "SELECT * FROM CompraFisica WHERE compra_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, compraId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CompraFisica(
                        rs.getInt("compra_id"),
                        rs.getInt("usuario_id"),
                        rs.getString("nombre_completo"),
                        rs.getString("direccion"),
                        rs.getString("ciudad"),
                        rs.getString("estado"),
                        rs.getString("codigo_postal"),
                        rs.getString("numero_tarjeta")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar compra: " + e.getMessage());
        }
        return null;
    }
}
