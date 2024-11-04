package vhs.palace;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;
import java.util.Random;

public class HomeScreen extends JFrame {

    private JTextField searchField;

    public HomeScreen() {
        setTitle("VHS Palace - Página de Inicio");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(10, 10, 30));

        JLabel titleLabel = new JLabel("Encuentra tu contenido favorito", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Verdana", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 255, 255));
        add(titleLabel, BorderLayout.NORTH);

        // Barra de búsqueda
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(20, 20, 40));
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(30);
        searchField.setFont(new Font("Verdana", Font.PLAIN, 16));
        searchField.setForeground(new Color(255, 255, 255));
        searchField.setBackground(new Color(30, 30, 50));
        searchField.setBorder(BorderFactory.createLineBorder(new Color(180, 0, 255), 2));
        searchField.setText("Busca películas, series, caricaturas, anime...");

        JButton searchButton = new JButton("Buscar");
        searchButton.setBackground(new Color(40, 40, 80));
        searchButton.setForeground(Color.WHITE);

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        add(searchPanel, BorderLayout.CENTER);

        // Acción del botón de búsqueda
        searchButton.addActionListener(e -> buscarContenido());

        JPanel suggestionPanel = new JPanel();
        suggestionPanel.setLayout(new GridLayout(2, 3, 20, 20));
        suggestionPanel.setBackground(new Color(20, 20, 40));

        // Mostrar sugerencias de Películas (Ejemplo Simulado)
        List<String> movies = List.of("Back to the Future", "The Matrix", "Star Wars", "Jurassic Park", "Blade Runner", "E.T.");
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            String movie = movies.get(random.nextInt(movies.size()));
            JButton movieButton = createMovieButton(movie);
            suggestionPanel.add(movieButton);
        }

        add(suggestionPanel, BorderLayout.SOUTH);
    }

    private void buscarContenido() {
        String query = searchField.getText().trim();
        if (!query.isEmpty()) {
            // Conectar con el servicio para realizar la búsqueda en la base de datos de películas.
            JOptionPane.showMessageDialog(this, "Buscando: " + query);
            // Placeholder para mostrar los resultados de la búsqueda.
            // Pueden ser detallados en una nueva ventana o en un panel.
        }
    }

    private JButton createMovieButton(String title) {
        JButton button = new JButton(title);
        button.setFont(new Font("SansSerif", Font.BOLD, 16));
        button.setBackground(new Color(40, 40, 80));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(new LineBorder(new Color(180, 0, 255), 2, true));

        button.addActionListener(e -> new MovieDetailScreen(title).setVisible(true));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen().setVisible(true));
    }
}