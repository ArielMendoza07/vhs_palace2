package DatabaseConnection;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DatabaseConnection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/VHS_PALACE";

    private static final String USER = "root"; // o tu usuario

    private static final String PASS = "22042003"; // tu contraseña

    public static Connection conectar() {

        Connection conexion = null;

        try {

            Class.forName(DRIVER);

            conexion = DriverManager.getConnection(URL, USER, PASS);

            System.out.println("Conexion exitosa");

        } catch (ClassNotFoundException | SQLException e) {

            System.out.println("Error en la conexion: " + e.getMessage());

        }

        return conexion;

    }

}
