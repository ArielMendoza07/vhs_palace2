package vhs.palace;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.Random;

class MovieDetailScreen extends  JFrame {
    public MovieDetailScreen(String title) {
        setTitle("Detalles de: " + title);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);

        JTextArea sinopsisArea = new JTextArea("Sinopsis de " + title + ". (Información simulada)");
        sinopsisArea.setLineWrap(true);
        sinopsisArea.setWrapStyleWord(true);
        sinopsisArea.setEditable(false);
        add(new JScrollPane(sinopsisArea), BorderLayout.CENTER);

        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        JButton verAhoraButton = new JButton("Ver Ahora");
        JButton comprarFisicoButton = new JButton("Comprar en Físico");

        actionPanel.add(verAhoraButton);
        actionPanel.add(comprarFisicoButton);
        add(actionPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        verAhoraButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Iniciando la reproducción de " + title));
        comprarFisicoButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Redirigiendo a la compra de " + title + " en físico"));
    }
}