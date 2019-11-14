package step_project_sketch;

import step_project_sketch.model.Booking;

import java.io.*;
import java.util.*;

public class BookingDAO implements DAO<Booking> {

    private File file;
    private Map<Integer, Booking> bookings;

    public BookingDAO(){
        this(new File("./db", "bookings.txt"));
    }

    public BookingDAO(File file){
        this.file = file;
        this.bookings = new HashMap<>();
    }

    @Override
    public Set<Booking> findAll() {
        return new HashSet<>(bookings.values());
    }

    @Override
    public Optional<Booking> findById(int id) {
        return Optional.ofNullable(bookings.get(id));
    }

    @Override
    public boolean create(Booking booking) {
        if (booking == null) throw new IllegalArgumentException("Trying to insert null into the map.");
        int id = booking.getId();
        if (bookings.containsKey(id)) {
            return false;
        } else {
            bookings.put(id, booking);
            return true;
        }
    }

    @Override
    public boolean remove(int id) {
        try{
            if (bookings.containsKey(id)) {
                bookings.remove(id);
            }
            return true;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new IllegalArgumentException("No such booking found.");
        }
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);

                Set<Booking> data = (HashSet<Booking>) ois.readObject();
                data.forEach(o -> {
                    Booking obj = o;
                    bookings.put(obj.getId(), obj);
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

    public void save() {
        try {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new HashSet<>(bookings.values()));
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("bookings.txt file not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error while initializing stream");
        }
    }
}
