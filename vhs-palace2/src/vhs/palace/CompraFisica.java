package vhs.palace;

public class CompraFisica {
    private int compraId;
    private int usuarioId;
    private String nombreCompleto;
    private String direccion;
    private String ciudad;
    private String estado;
    private String codigoPostal;
    private String numeroTarjeta;

    // Constructor completo
    public CompraFisica(int compraId, int usuarioId, String nombreCompleto, String direccion, String ciudad, String estado, String codigoPostal, String numeroTarjeta) {
        this.compraId = compraId;
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
        this.numeroTarjeta = numeroTarjeta;
    }

    // Constructor vacío
    public CompraFisica() {}

    // Getters y Setters
    public int getCompraId() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }
}

