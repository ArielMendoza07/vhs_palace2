package vhs.palace;

import Servicios.MembresiaService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MembresiaForm extends JFrame {

    private MembresiaService membresiaService = new MembresiaService();
    private JTextField membresiaIdField, usuarioIdField, fechaInicioField, fechaFinField, tipoField;

    public MembresiaForm() {
        setTitle("Gestión de Membresías");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel membresiaIdLabel = new JLabel("Membresía ID:");
        membresiaIdLabel.setBounds(20, 20, 100, 30);
        add(membresiaIdLabel);

        membresiaIdField = new JTextField();
        membresiaIdField.setBounds(120, 20, 200, 30);
        add(membresiaIdField);

        JLabel usuarioIdLabel = new JLabel("Usuario ID:");
        usuarioIdLabel.setBounds(20, 70, 100, 30);
        add(usuarioIdLabel);

        usuarioIdField = new JTextField();
        usuarioIdField.setBounds(120, 70, 200, 30);
        add(usuarioIdField);

        JLabel fechaInicioLabel = new JLabel("Fecha Inicio:");
        fechaInicioLabel.setBounds(20, 120, 100, 30);
        add(fechaInicioLabel);

        fechaInicioField = new JTextField();
        fechaInicioField.setBounds(120, 120, 200, 30);
        add(fechaInicioField);

        JLabel fechaFinLabel = new JLabel("Fecha Fin:");
        fechaFinLabel.setBounds(20, 170, 100, 30);
        add(fechaFinLabel);

        fechaFinField = new JTextField();
        fechaFinField.setBounds(120, 170, 200, 30);
        add(fechaFinField);

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
                Membresia membresia = new Membresia();
                membresia.setUsuarioId(Integer.parseInt(usuarioIdField.getText()));
                membresia.setFechaInicio(fechaInicioField.getText());
                membresia.setFechaFin(fechaFinField.getText());
                membresia.setTipo(tipoField.getText());

                membresiaService.registrarMembresia(membresia);
                JOptionPane.showMessageDialog(null, "Membresía agregada con éxito!");
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int membresiaId = Integer.parseInt(membresiaIdField.getText());
                Membresia membresia = membresiaService.obtenerMembresia(membresiaId);
                if (membresia != null) {
                    usuarioIdField.setText(String.valueOf(membresia.getUsuarioId()));
                    fechaInicioField.setText(membresia.getFechaInicio());
                    fechaFinField.setText(membresia.getFechaFin());
                    tipoField.setText(membresia.getTipo());
                    JOptionPane.showMessageDialog(null, "Membresía encontrada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Membresía no encontrada.");
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int membresiaId = Integer.parseInt(membresiaIdField.getText());
                Membresia membresia = membresiaService.obtenerMembresia(membresiaId);
                if (membresia != null) {
                    membresia.setUsuarioId(Integer.parseInt(usuarioIdField.getText()));
                    membresia.setFechaInicio(fechaInicioField.getText());
                    membresia.setFechaFin(fechaFinField.getText());
                    membresia.setTipo(tipoField.getText());
                    membresiaService.actualizarMembresia(membresia);
                    JOptionPane.showMessageDialog(null, "Membresía actualizada con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "Membresía no encontrada.");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int membresiaId = Integer.parseInt(membresiaIdField.getText());
                Membresia membresia = membresiaService.obtenerMembresia(membresiaId);
                if (membresia != null) {
                    membresiaService.eliminarMembresia(membresiaId);
                    JOptionPane.showMessageDialog(null, "Membresía eliminada con éxito!");
                } else {
                    JOptionPane.showMessageDialog(null, "Membresía no encontrada.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MembresiaForm().setVisible(true);
        });
    }
}
