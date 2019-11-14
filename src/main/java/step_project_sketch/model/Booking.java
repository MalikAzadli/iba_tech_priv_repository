package step_project_sketch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Booking implements Serializable {

    private int id;
    private LocalDateTime date;
    private Seat seat;
    private Flight flight;
    private User user;
    private Passenger passenger;

    public Booking(int id, Seat seat, Flight flight, User user) {
        this.id = id;
        this.seat = seat;
        this.flight = flight;
        this.user = user;
    }

    public Booking(int id, Seat seat, Flight flight, User user, Passenger passenger) {
        this.id = id;
        this.seat = seat;
        this.flight = flight;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Booking {")
                .append("id=").append(id)
                .append("passenger=")
                .append(", flight=").append(flight)
                .append(", seat=").append(seat)
                .append("}").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return id == booking.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seat, flight, user);
    }
}
