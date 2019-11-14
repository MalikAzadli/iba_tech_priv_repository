package step_project_sketch;

import step_project_sketch.model.User;

import java.io.*;
import java.util.*;

public class UserDAO implements DAO<User> {
    private File file;
    private Map<Integer, User> users;

    public UserDAO(){
        this(new File("./db", "user.txt"));
    }

    public UserDAO(File file){
        this.file = file;
        this.users = new HashMap<>();
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(users.values());
    }

    @Override
    public Optional<User> findById(int id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public boolean create(User user) {
        if (user == null) throw new IllegalArgumentException("Trying to insert null into the map.");
        int id = user.getId();
        if (users.containsKey(id)) {
            return false;
        } else {
            users.put(id, user);
            return true;
        }
    }

    @Override
    public boolean remove(int id) {
        try{
            if (users.containsKey(id)) {
                users.remove(id);
            }
            return true;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new IllegalArgumentException("No such user found.");
        }
    }

    @Override
    public void load() {
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);

                Set<User> data = (HashSet<User>) ois.readObject();
                data.forEach(o -> {
                    User obj = o;
                    users.put(obj.getId(), obj);
                });
                ois.close();
                fis.close();
            }
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File isn't there.");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Can't initialize the stream.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new HashSet<>(users.values()));
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("users.txt file not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error while initializing stream");
        }
    }
}
