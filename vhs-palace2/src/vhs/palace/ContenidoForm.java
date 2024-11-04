package vhs.palace;

import Servicios.ContenidoService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContenidoForm extends JFrame {
    private ContenidoService contenidoService = new ContenidoService();
    private JTextField contenidoIdField, tituloField, generoField, formatoField, anoField, precioField, stockField;

    public ContenidoForm() {
        setTitle("Gestión de Contenido");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel tituloLabel = new JLabel("Título:");
        tituloLabel.setBounds(20, 20, 100, 30);
        add(tituloLabel);

        tituloField = new JTextField();
        tituloField.setBounds(120, 20, 200, 30);
        add(tituloField);

        // Botón para agregar contenido
        JButton agregarButton = new JButton("Agregar");
        agregarButton.setBounds(20, 320, 100, 30);
        add(agregarButton);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Contenido contenido = new Contenido();
                    contenido.setTitulo(tituloField.getText());
                    contenidoService.registrarPelicula(contenido);
                    JOptionPane.showMessageDialog(null, "Contenido agregado con éxito!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar contenido: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ContenidoForm().setVisible(true);
        });
    }
}