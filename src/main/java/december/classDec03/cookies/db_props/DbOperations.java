package december.classDec03.cookies.db_props;

import december.classDec03.cookies.entities.History;
import december.classDec03.cookies.entities.Operation;
import december.classDec03.cookies.entities.User;
import november.classNov28.database.DbConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbOperations {
    public static void addHistory(History item) throws SQLException {
        Connection connection = DbConn.get();
        Operation operation = item.getOperation();
        String username = item.getUser().getUsername();
        String op1 = operation.getOp1();
        String op2 = operation.getOp2();
        String op = operation.getOperation();
        String command = "insert into history(op1, operation, op2, \"user\") values (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(command);
        preparedStatement.setString(1, op1);
        preparedStatement.setString(2, op);
        preparedStatement.setString(3, op2);
        preparedStatement.setString(4, username);
        preparedStatement.execute();
    }

    public static List<History> getHistory() throws SQLException {
        Connection connection = DbConn.get();
        String command = "select * from history";
        PreparedStatement preparedStatement = connection.prepareStatement(command);
        ResultSet outcome = preparedStatement.executeQuery();
        ArrayList<History> data = new ArrayList<>();
        while (outcome.next()) {
            String op1 = outcome.getString("op1");
            String operation = outcome.getString("operation");
            String op2 = outcome.getString("op2");
            User user = new User();
            user.setUsername(outcome.getString("user"));
            Operation histItem = new Operation(op1, operation, op2);
            History history = new History(user, histItem);
            data.add(history);
        }
        return data;
    }

    public static boolean isValidUser(String username, String password) throws SQLException {
        Connection connection = DbConn.get();
        String command = "select * from user_auth where username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(command);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet outcome = preparedStatement.executeQuery();
        while (outcome.next()){
            if(outcome.getString("username").equals(username) && outcome.getString("password").equals(password)) {
                return true;
            }
        }
        return false;
    }
}
