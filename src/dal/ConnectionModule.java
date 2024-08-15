package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.exit;

public class ConnectionModule {

    public static Connection connection() {
        String URL = "jdbc:mysql://localhost:3306/menu";
        String USER = "root";
        String PASSWORD = "admin";

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar com o banco de dados");
            exit(0);
            return null;
        }

    }
}
