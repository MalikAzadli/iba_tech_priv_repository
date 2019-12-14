package _practice.dbPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection get() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(
                    System.getenv("DB_PATH"),
                    System.getenv("DB_USER"),
                    System.getenv("DB_PSWD")
            );
        }
        return connection;
    }
}
