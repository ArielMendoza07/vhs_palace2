package DAOs;

import DatabaseConnection.DatabaseConnection;
import vhs.palace.*;
import vhs.palace.Contenido;
        
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContenidoDAO {
    public void crearPelicula(Contenido pelicula) {
        String query = "INSERT INTO Pelicula (titulo, genero, formato, ano, precio, stock) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getFormato());
            ps.setInt(4, pelicula.getAno());
            ps.setDouble(5, pelicula.getPrecio());
            ps.setInt(6, pelicula.getStock());
            ps.executeUpdate();
            System.out.println("Película creada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al crear película: " + e.getMessage());
        }
    }

    public Contenido buscarPelicula(int peliculaId) {
        String query = "SELECT * FROM Pelicula WHERE pelicula_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, peliculaId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Contenido(rs.getInt("pelicula_id"), rs.getString("titulo"), rs.getString("genero"), rs.getString("formato"), rs.getInt("ano"), rs.getDouble("precio"), rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar película: " + e.getMessage());
        }
        return null;
    }

    public void actualizarPelicula(Contenido pelicula) {
        String query = "UPDATE Pelicula SET titulo = ?, genero = ?, formato = ?, ano = ?, precio = ?, stock = ? WHERE pelicula_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setString(3, pelicula.getFormato());
            ps.setInt(4, pelicula.getAno());
            ps.setDouble(5, pelicula.getPrecio());
            ps.setInt(6, pelicula.getStock());
            ps.setInt(7, pelicula.getPeliculaId());
            ps.executeUpdate();
            System.out.println("Película actualizada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al actualizar película: " + e.getMessage());
        }
    }

    public void eliminarPelicula(int peliculaId) {
        String query = "DELETE FROM Pelicula WHERE pelicula_id = ?";
        try (Connection conexion = DatabaseConnection.conectar();
             PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, peliculaId);
            ps.executeUpdate();
            System.out.println("Película eliminada exitosamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar película: " + e.getMessage());
        }
    }
}