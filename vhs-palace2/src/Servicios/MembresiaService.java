package Servicios;

import DAOs.*;
import vhs.palace.*;


public class MembresiaService {
    private MembresiaDAO membresiaDAO;

    public MembresiaService() {
        this.membresiaDAO = new MembresiaDAO();
    }

    public void registrarMembresia(Membresia membresia) {
        if (membresia.getTipo() == null || membresia.getTipo().isEmpty()) {
            System.out.println("El tipo de membresía no puede estar vacío.");
            return;
        }
        membresiaDAO.crearMembresia(membresia);
    }

    public Membresia obtenerMembresia(int membresiaId) {
        return membresiaDAO.buscarMembresia(membresiaId);
    }

    public void actualizarMembresia(Membresia membresia) {
        Membresia membresiaExistente = membresiaDAO.buscarMembresia(membresia.getMembresiaId());
        if (membresiaExistente == null) {
            System.out.println("La membresía no existe.");
            return;
        }
        membresiaDAO.actualizarMembresia(membresia);
    }

    public void eliminarMembresia(int membresiaId) {
        Membresia membresiaExistente = membresiaDAO.buscarMembresia(membresiaId);
        if (membresiaExistente == null) {
            System.out.println("La membresía no existe.");
            return;
        }
        membresiaDAO.eliminarMembresia(membresiaId);
    }
}
