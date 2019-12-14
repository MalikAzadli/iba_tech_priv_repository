package _practice.dbPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBPractice {
    public static void main(String[] args) {
        DBPractice db = new DBPractice();
        db.get_unreacted_user(1);
        db.addLike();
        db.get_all_like_users(1);
    }

    public void addLike() {
        try (Connection conn = DBConnection.get()) {
            int liker_id = 6;
            int liked_id = 7;
            boolean sympathy = true;
            String query = "insert into \"like\" (liker_id, liked_id, sympathy) VALUES (?,?,?);";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, liker_id);
            statement.setInt(2, liked_id);
            statement.setBoolean(3, sympathy);
            statement.execute();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("ADD LIKE: Database was not connected!!");
        }
    }

    public void get_unreacted_user(int id) {
        try (Connection conn = DBConnection.get()) {

            String query = "select * from \"user\" where id != ? " +
                    "except " +
                    "select distinct u.* from \"user\" as u " +
                    "join \"like\" on (liked_id = u.id and liker_id = ?) " +
                    "order by id";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int chosen_id = resultSet.getInt("id");
                System.out.println(chosen_id);
            }



        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("GET UNREACTED: Some problem emerged!!");
        }
    }

    public void get_all_like_users(int id){
        try (Connection conn = DBConnection.get()) {
            String query = "select distinct u.* from \"user\" as u join \"like\" on (liked_id = u.id and liker_id = ?) order by u.id";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_chosen = resultSet.getInt("id");
                System.out.println(id_chosen);
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("GET ALL: some problem with database!!");
        }
    }
}
