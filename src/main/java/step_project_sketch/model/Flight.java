package step_project_sketch.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class Flight implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int fCounter = 0;

    private int id;
    private String flightNo;
    private Airplane airplane;
    private LocalDateTime departure;
    private Airport origin;
    private LocalDateTime arrival;
    private Airport destination;
    private HashSet<Passenger> passengers;

    public Flight(String flightNo) {
        this.flightNo = flightNo;
    }

    public Flight(int id, String flightNo) {
        this.id = id;
        this.flightNo = flightNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public long availableSeats() {
        return Arrays.stream(airplane.getSeats()).filter(Seat::isEmpty).count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                Objects.equals(flightNo, flight.flightNo) &&
                Objects.equals(airplane, flight.airplane) &&
                Objects.equals(departure, flight.departure) &&
                Objects.equals(origin, flight.origin) &&
                Objects.equals(arrival, flight.arrival) &&
                Objects.equals(destination, flight.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightNo, airplane, departure, origin, arrival, destination);
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Flight {")
                .append("flightNo=").append(flightNo)
                .append(", departureTime=").append(departure)
                .append(", departureLocation=").append(origin)
                .append(", arrivalTime=").append(arrival)
                .append(", arrivalLocation=").append(destination)
                .append("}").toString();
    }
}
