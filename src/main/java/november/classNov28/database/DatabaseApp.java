package november.classNov28.database;

import java.sql.SQLException;
import java.util.List;

public class DatabaseApp {
    public static void main(String[] args) throws SQLException {
        DbOperation.insert_user("James", "caan@gmai.com");
        List<User> users = DbOperation.get_all_users();
        users.forEach(user -> System.out.printf("%d : %-8s : %s\n",
                user.getId(), user.getName(), user.getEmail()));
    }
}
