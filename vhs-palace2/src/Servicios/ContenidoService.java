package Servicios;

import DAOs.*;
import vhs.palace.*;



public class ContenidoService {
    private ContenidoDAO peliculaDAO;

    public ContenidoService() {
        this.peliculaDAO = new ContenidoDAO();
    }

    public void registrarPelicula(Contenido pelicula) {
        if (pelicula.getTitulo() == null || pelicula.getTitulo().isEmpty()) {
            System.out.println("El título de la película no puede estar vacío.");
            return;
        }
        if (pelicula.getPrecio() <= 0) {
            System.out.println("El precio de la película debe ser mayor que cero.");
            return;
        }
        peliculaDAO.crearPelicula(pelicula);
    }

    public Contenido obtenerPelicula(int peliculaId) {
        return peliculaDAO.buscarPelicula(peliculaId);
    }

    public void actualizarPelicula(Contenido pelicula) {
        Contenido peliculaExistente = peliculaDAO.buscarPelicula(pelicula.getPeliculaId());
        if (peliculaExistente == null) {
            System.out.println("La película no existe.");
            return;
        }
        peliculaDAO.actualizarPelicula(pelicula);
    }

    public void eliminarPelicula(int peliculaId) {
        Contenido peliculaExistente = peliculaDAO.buscarPelicula(peliculaId);
        if (peliculaExistente == null) {
            System.out.println("La película no existe.");
            return;
        }
        peliculaDAO.eliminarPelicula(peliculaId);
    }
}
