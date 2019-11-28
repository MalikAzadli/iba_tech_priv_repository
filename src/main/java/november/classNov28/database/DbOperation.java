package november.classNov28.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbOperation {

    public static void insert_user(String name, String email) throws SQLException {
        Connection connection = DbConn.get();
        String command = "insert into users(name, email) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(command);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.execute();
    }

    public static List<User> get_all_users() throws SQLException {
        Connection connection = DbConn.get();
        String command = "select * from users";
        PreparedStatement preparedStatement = connection.prepareStatement(command);
        ResultSet outcome = preparedStatement.executeQuery();
        ArrayList<User> data = new ArrayList<>();

        while (outcome.next()){
            int id = outcome.getInt("id");
            String name = outcome.getString("name");
            String email = outcome.getString("email");
            User user = new User(id, name, email);
            data.add(user);
        }
        return data;
    }
}
