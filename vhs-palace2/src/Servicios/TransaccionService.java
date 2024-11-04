package Servicios;

import DAOs.TransaccionDAO;
import vhs.palace.Transaccion;

public class TransaccionService {
    private TransaccionDAO transaccionDAO;

    public TransaccionService() {
        this.transaccionDAO = new TransaccionDAO();
    }

    public void registrarTransaccion(Transaccion transaccion) {
        if ("COMPRA".equalsIgnoreCase(transaccion.getTipo()) && (transaccion.getTotal() <= 0 || transaccion.getDetallesEnvio() == null || transaccion.getDetallesEnvio().isEmpty())) {
            System.out.println("Detalles inválidos para la compra. Verifique el total y la dirección de envío.");
            return;
        }
        if ("VISUALIZACION".equalsIgnoreCase(transaccion.getTipo()) && transaccion.getTotal() != 0) {
            System.out.println("El total para una visualización debe ser 0.");
            return;
        }
        transaccionDAO.crearTransaccion(transaccion);
    }

    public Transaccion obtenerTransaccion(int transaccionId) {
        return transaccionDAO.buscarTransaccion(transaccionId);
    }

    public void actualizarTransaccion(Transaccion transaccion) {
        Transaccion transaccionExistente = transaccionDAO.buscarTransaccion(transaccion.getTransaccionId());
        if (transaccionExistente == null) {
            System.out.println("La transacción no existe.");
            return;
        }
        transaccionDAO.actualizarTransaccion(transaccion);
    }

    public void eliminarTransaccion(int transaccionId) {
        Transaccion transaccionExistente = transaccionDAO.buscarTransaccion(transaccionId);
        if (transaccionExistente == null) {
            System.out.println("La transacción no existe.");
            return;
        }
        transaccionDAO.eliminarTransaccion(transaccionId);
    }
}