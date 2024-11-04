// Usuario.java
package vhs.palace;

public class Usuario {
    private int usuarioId;
    private String nombre;
    private String correo;
    private String contrasena;
    private String tipo;

    // Constructor completo
    public Usuario(int usuarioId, String nombre, String correo, String contrasena, String tipo) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    // Constructor vacío
    public Usuario() {}

    // Getters y Setters
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}