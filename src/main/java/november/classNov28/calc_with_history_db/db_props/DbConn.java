package november.classNov28.calc_with_history_db.db_props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn {
    private static Connection connection;

    public static Connection get() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/iba",
                    "postgres",
                    System.getenv("PG_PWD")
            );
        }
        return connection;
    }
}
