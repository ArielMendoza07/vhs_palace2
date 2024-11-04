package vhs.palace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Menú Principal - VHS Palace");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(30, 30, 60));

        JButton usuarioButton = new JButton("Gestión de Usuarios");
        usuarioButton.setBounds(50, 30, 200, 40);
        add(usuarioButton);

        JButton contenidoButton = new JButton("Gestión de Contenidos");
        contenidoButton.setBounds(50, 80, 200, 40);
        add(contenidoButton);

        JButton membresiaButton = new JButton("Gestión de Membresías");
        membresiaButton.setBounds(50, 130, 200, 40);
        add(membresiaButton);

        JButton transaccionButton = new JButton("Gestión de Transacciones");
        transaccionButton.setBounds(50, 180, 200, 40);
        add(transaccionButton);

        JButton homeScreenButton = new JButton("Ir a HomeScreen");
        homeScreenButton.setBounds(300, 30, 200, 40);
        add(homeScreenButton);

        JButton salirButton = new JButton("Salir");
        salirButton.setBounds(300, 80, 200, 40);
        add(salirButton);

        usuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new UsuarioForm().setVisible(true);
            }
        });

        contenidoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ContenidoForm().setVisible(true);
            }
        });

        membresiaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MembresiaForm().setVisible(true);
            }
        });

        transaccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TransaccionForm().setVisible(true);
            }
        });

        homeScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeScreen().setVisible(true);
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu().setVisible(true);
        });
    }
}