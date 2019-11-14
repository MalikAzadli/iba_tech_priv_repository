package step_project_sketch;

import java.util.Optional;

public class InputChecker {
    private final FlightController flightController;
    private final BookingController bookingController;

    public InputChecker(FlightController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    public boolean isCommand(String line) {
        return true;
    }

    public boolean isFlightId(String input) {

        return true;
    }

    public boolean isBookingId(String line) {
        Optional<Integer> id = convertToInteger(line);
//        if (id.isEmpty()) return false;

        return true;
    }

    public boolean isClientName(String fullName) {
        return true;
    }

    public boolean check(String line, Object object){
        boolean flag = false;

        switch (object.getClass().getSimpleName()){
            case "FLIGHT_NO": if(isFlightId(line)) flag = true; break;
            case "CLIENT_NAME": if(isClientName(line)) flag = true; break;
            case "BOOKING_ID": if(isBookingId(line)) flag = true; break;
        }
        return flag;
    }

    private Optional<Integer> convertToInteger(String line){
        Integer number;
        try{
            number = Integer.parseInt(line);
        } catch (Exception ex){
            throw new IllegalArgumentException("Invalid Argument. Not an integer.");
        }
        return Optional.ofNullable(number);
    }

}
