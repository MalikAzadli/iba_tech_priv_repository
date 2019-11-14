package step_project_sketch;

import step_project_sketch.model.Flight;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FlightService {

    private final FlightDAO flightDAO;

    public FlightService(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }

    public Set<Flight> getAll() {
        return null;
    }

    public Flight getByFlightDate(LocalDate flightDate) {
        return null;
    }

    public Flight getByDestination(String destination) {
        return null;
    }

    public Map<String, String> getFlightInfoRequest(){
        Map<String, String> requests = new HashMap<>();
        requests.put("Please, enter flight no: ", "FLIGHT_NO");
        return requests;
    }
}
