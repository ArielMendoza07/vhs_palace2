package Servicios;

import DAOs.UsuarioDAO;
import vhs.palace.Usuario;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void registrarUsuario(Usuario usuario) {
        // Validaciones de negocio (por ejemplo, correo único)
        if (null == usuario.getCorreo() || usuario.getCorreo().isEmpty()) {
            System.out.println("El correo no puede estar vacío.");
            return;
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().length() < 6) {
            System.out.println("La contraseña debe tener al menos 6 caracteres.");
            return;
        }
        usuarioDAO.crearUsuario(usuario);
    }

    public Usuario obtenerUsuario(int usuarioId) {
        return usuarioDAO.buscarUsuario(usuarioId);
    }

    public void actualizarUsuario(Usuario usuario) {
        // Validaciones de negocio (por ejemplo, verificar si el usuario existe antes de actualizar)
        Usuario usuarioExistente = usuarioDAO.buscarUsuario(usuario.getUsuarioId());
        if (usuarioExistente == null) {
            System.out.println("El usuario no existe.");
            return;
        }
        usuarioDAO.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int usuarioId) {
        // Validaciones de negocio (por ejemplo, verificar si el usuario tiene transacciones activas antes de eliminar)
        Usuario usuarioExistente = usuarioDAO.buscarUsuario(usuarioId);
        if (usuarioExistente == null) {
            System.out.println("El usuario no existe.");
            return;
        }
        usuarioDAO.eliminarUsuario(usuarioId);
    }
}
