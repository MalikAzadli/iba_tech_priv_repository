package step_project_sketch.model;

public class Airplane {
    private String code;
    private String model;
    private Airline airline;
    private int capacity;
    private Seat[] seats;

    public Airplane(String code, String model, int capacity) {
        this.code = code;
        this.model = model;
        this.capacity = capacity;
        this.seats = new Seat[capacity];
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }
}
