package vhs.palace;

public class Transaccion {
    private int transaccionId;
    private int usuarioId;
    private String fecha;
    private double total;
    private String estado;
    private String tipo; // "COMPRA" o "VISUALIZACION"
    private String detallesEnvio; // Solo para compras físicas

    // Constructor completo
    public Transaccion(int transaccionId, int usuarioId, String fecha, double total, String estado, String tipo, String detallesEnvio) {
        this.transaccionId = transaccionId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.tipo = tipo;
        this.detallesEnvio = detallesEnvio;
    }

    // Constructor vacío
    public Transaccion() {}

    // Getters y Setters
    public int getTransaccionId() {
        return transaccionId;
    }

    public void setTransaccionId(int transaccionId) {
        this.transaccionId = transaccionId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetallesEnvio() {
        return detallesEnvio;
    }

    public void setDetallesEnvio(String detallesEnvio) {
        this.detallesEnvio = detallesEnvio;
    }
}
