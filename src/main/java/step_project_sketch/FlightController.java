package step_project_sketch;

import java.util.Map;

public class FlightController {

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public  Map<String, String> getFlightInfoRequests(){
        return flightService.getFlightInfoRequest();
    }
}
