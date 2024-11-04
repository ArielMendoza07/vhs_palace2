package DAOs;

import DatabaseConnection.DatabaseConnection;
import vhs.palace.*;
import vhs.palace.Usuario;
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    public void crearUsuario(Usuario usuario) {
        String query = "INSERT INTO Usuario (nombre, correo, contrasena, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getTipo());
            ps.executeUpdate();
            System.out.println("Usuario creado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }

    public Usuario buscarUsuario(int usuarioId) {
        String query = "SELECT * FROM Usuario WHERE usuario_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Usuario(rs.getInt("usuario_id"), rs.getString("nombre"), rs.getString("correo"), rs.getString("contrasena"), rs.getString("tipo"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar usuario: " + e.getMessage());
        }
        return null;
    }

    public void actualizarUsuario(Usuario usuario) {
        String query = "UPDATE Usuario SET nombre = ?, correo = ?, contrasena = ?, tipo = ? WHERE usuario_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setString(4, usuario.getTipo());
            ps.setInt(5, usuario.getUsuarioId());
            ps.executeUpdate();
            System.out.println("Usuario actualizado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(int usuarioId) {
        String query = "DELETE FROM Usuario WHERE usuario_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, usuarioId);
            ps.executeUpdate();
            System.out.println("Usuario eliminado exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }
}