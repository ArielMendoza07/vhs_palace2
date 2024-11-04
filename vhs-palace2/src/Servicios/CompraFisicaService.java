package Servicios;

import DAOs.CompraFisicaDAO;
import vhs.palace.CompraFisica;

public class CompraFisicaService {
    private CompraFisicaDAO compraFisicaDAO;

    public CompraFisicaService() {
        this.compraFisicaDAO = new CompraFisicaDAO();
    }

    public void registrarCompra(CompraFisica compraFisica) {
        if (compraFisica.getNombreCompleto().isEmpty() || compraFisica.getDireccion().isEmpty()) {
            System.out.println("Los campos de nombre y dirección no pueden estar vacíos.");
            return;
        }
        compraFisicaDAO.registrarCompra(compraFisica);
    }

    public CompraFisica obtenerCompra(int compraId) {
        return compraFisicaDAO.buscarCompra(compraId);
    }
}
