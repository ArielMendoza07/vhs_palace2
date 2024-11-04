
package vhs.palace;

public class Administrador extends Usuario {
    private String privilegios;

    // Constructor completo
    public Administrador(int usuarioId, String nombre, String correo, String contrasena, String tipo, String privilegios) {
        super(usuarioId, nombre, correo, contrasena, tipo);
        this.privilegios = privilegios;
    }

    // Constructor vacío
    public Administrador() {}

    // Getters y Setters
    public String getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(String privilegios) {
        this.privilegios = privilegios;
    }
}
