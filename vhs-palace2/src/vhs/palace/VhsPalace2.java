package vhs.palace;

import javax.swing.*;

public class VhsPalace2 {

    public static void main(String[] args) {
        // Intentar inicializar la aplicación
        SwingUtilities.invokeLater(() -> {
            try {
                MainMenu mainMenu = new MainMenu();
                mainMenu.setVisible(true);
            } catch (Exception e) {
                System.out.println("Error inicializando la aplicación: " + e.getMessage());
                JOptionPane.showMessageDialog(null, "No se pudo inicializar la aplicación. Verifica la configuración.", "Error de Inicio", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
