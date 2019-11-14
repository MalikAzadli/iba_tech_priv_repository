package step_project_sketch;

import step_project_sketch.model.Flight;

import java.io.*;
import java.util.*;

public class FlightDAO implements DAO<Flight> {

    private File file;
    private Map<Integer, Flight> flights;

    public FlightDAO(){
        this(new File("./db", "flights.txt"));
    }

    public FlightDAO(File file){
        this.file = file;
        this.flights = new HashMap<>();
    }

    @Override
    public Set<Flight> findAll() {
        return new HashSet<>(flights.values());
    }

    @Override
    public Optional<Flight> findById(int id) {
        return Optional.ofNullable(flights.get(id));
    }

    @Override
    public boolean create(Flight flight) {
        if (flight == null) throw new IllegalArgumentException("Trying to insert null into the map.");
        int id = flight.getId();
        if (flights.containsKey(id)) {
            return false;
        } else {
            flights.put(id, flight);
            return true;
        }
    }

    @Override
    public boolean remove(int id) {
        try{
            if (flights.containsKey(id)) {
                flights.remove(id);
            }
            return true;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw new IllegalArgumentException("No such flight found.");
        }
    }

    @Override
    public void load() {
        try {
            FileInputStream fis = new FileInputStream(file);
            if (fis.available() > 0) {
                ObjectInputStream ois = new ObjectInputStream(fis);

                Set<Flight> data = (HashSet<Flight>) ois.readObject();
                data.forEach(o -> {
                    Flight obj = o;
                    flights.put(obj.getId(), obj);
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
            oos.writeObject(new HashSet<>(flights.values()));
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("flights.txt file not found");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error while initializing stream");
        }
    }
}
