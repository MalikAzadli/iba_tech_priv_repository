package step_project_sketch.model;

import java.io.Serializable;
import java.util.HashSet;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private HashSet<Booking> bookings;

    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(int id, String username, String password, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
