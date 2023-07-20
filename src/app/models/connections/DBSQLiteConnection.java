package app.models.connections;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public final class DBSQLiteConnection {
    // Ruta relativa de base de datos SQLite
    private static final String DB_URL = System.getProperty("user.dir") + "/src/db/sqlite/libraryShop.db";
    private static DBSQLiteConnection instance;
    private static Connection connection;

    public static DBSQLiteConnection getInstance() {
        if (instance == null) {
            instance = new DBSQLiteConnection();
        }
        return instance;
    }
    
    public DBSQLiteConnection () {
        try {
            // Cargar el controlador JDBC para SQLite
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_URL);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }      
    }
    
    public static Connection getConnection() {
        return connection;
    }
    
//    public static Connection getConnection() {
//        if (connection == null) {
//            try {
//                // Cargar el controlador JDBC para SQLite
//                Class.forName("org.sqlite.JDBC"); 
//                connection = DriverManager.getConnection("jdbc:sqlite:" + DB_URL);
//                System.out.println("Conexión exitosa a la base de datos.");
//            } catch (ClassNotFoundException e) {
//                System.out.println("Error al cargar el controlador JDBC: " + e.getMessage());
//            } catch (SQLException e) {
//                System.out.println("Error al conectar con la base de datos: " + e.getMessage());
//            }
//        }
//        return connection;
//    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}

