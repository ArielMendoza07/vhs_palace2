package vhs.palace;

import Servicios.TransaccionService;
import vhs.palace.Transaccion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransaccionForm extends JFrame {
    private TransaccionService transaccionService = new TransaccionService();
    private JTextField transaccionIdField, usuarioIdField, totalField;

    public TransaccionForm() {
        setTitle("Gestión de Transacciones");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel transaccionIdLabel = new JLabel("Transacción ID:");
        transaccionIdLabel.setBounds(20, 20, 100, 30);
        add(transaccionIdLabel);

        transaccionIdField = new JTextField();
        transaccionIdField.setBounds(120, 20, 200, 30);
        add(transaccionIdField);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.setBounds(130, 270, 100, 30);
        add(buscarButton);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int transaccionId = Integer.parseInt(transaccionIdField.getText());
                    Transaccion transaccion = transaccionService.obtenerTransaccion(transaccionId);
                    if (transaccion != null) {
                        usuarioIdField.setText(String.valueOf(transaccion.getUsuarioId()));
                        totalField.setText(String.valueOf(transaccion.getTotal()));
                        JOptionPane.showMessageDialog(null, "Transacción encontrada.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Transacción no encontrada.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un ID válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TransaccionForm().setVisible(true);
        });
    }
}