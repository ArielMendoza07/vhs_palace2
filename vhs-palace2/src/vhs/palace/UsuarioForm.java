package vhs.palace;

import Servicios.UsuarioService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioForm extends JFrame {

    private UsuarioService usuarioService = new UsuarioService();
    private JTextField usuarioIdField, nombreField, correoField, contrasenaField, tipoField;

    public UsuarioForm() {
        setTitle("Gestión de Usuarios");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usuarioIdLabel = new JLabel("Usuario ID:");
        usuarioIdLabel.setBounds(20, 20, 100, 30);
        add(usuarioIdLabel);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(120, 20, 200, 30);
        add(usuarioIdField);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(20, 70, 100, 30);
        add(nombreLabel);

        nombreField = new JTextField();
        nombreField.setBounds(120, 70, 200, 30);
        add(nombreField);

        JLabel correoLabel = new JLabel("Correo:");
        correoLabel.setBounds(20, 120, 100, 30);
        add(correoLabel);

        correoField = new JTextField();
        correoField.setBounds(120, 120, 200, 30);
        add(correoField);

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setBounds(20, 170, 100, 30);
        add(contrasenaLabel);

        contrasenaField = new JTextField();
        contrasenaField.setBounds(120, 170, 200, 30);
        add(contrasenaField);

        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setBounds(20, 220, 100, 30);
        add(tipoLabel);

        tipoField = new JTextField();
        tipoField.setBounds(120, 220, 200, 30);
        add(tipoField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.setBounds(20, 270, 100, 30);
        add(agregarButton);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(130, 270, 100, 30);
        add(buscarButton);

        JButton actualizarButton = new JButton("Actualizar");
        actualizarButton.setBounds(240, 270, 100, 30);
        add(actualizarButton);

        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.setBounds(350, 270, 100, 30);
        add(eliminarButton);

        // Action Listeners para los botones
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario usuario = new Usuario();
                usuario.setNombre(nombreField.getText());
                usuario.setCorreo(correoField.getText());
                usuario.setContrasena(contrasenaField.getText());
                usuario.setTipo(tipoField.getText());

                usuarioService.registrarUsuario(usuario);
                JOptionPane.showMessageDialog(null, "Usuario agregado con éxito!");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usuarioId = Integer.parseInt(usuarioIdField.getText());
                Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
                if (usuario != null) {
                    nombreField.setText(usuario.getNombre());
                    correoField.setText(usuario.getCorreo());
                    contrasenaField.setText(usuario.getContrasena());
                    tipoField.setText(usuario.getTipo());
                    JOptionPane.showMessageDialog(null, "Usuario encontrado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usuarioId = Integer.parseInt(usuarioIdField.getText());
                Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
                if (usuario != null) {
                    usuario.setNombre(nombreField.getText());
                    usuario.setCorreo(correoField.getText());
                    usuario.setContrasena(contrasenaField.getText());
                    usuario.setTipo(tipoField.getText());
                    usuarioService.actualizarUsuario(usuario);
                    JOptionPane.showMessageDialog(null, "Usuario actualizado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usuarioId = Integer.parseInt(usuarioIdField.getText());
                Usuario usuario = usuarioService.obtenerUsuario(usuarioId);
                if (usuario != null) {
                    usuarioService.eliminarUsuario(usuarioId);
                    JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new UsuarioForm().setVisible(true);
        });
    }
}
