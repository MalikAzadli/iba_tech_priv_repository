package step_project_sketch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Switcher {

    private final FlightController flightController;
    private final BookingController bookingController;
    private Commands command;
    private  Map<String, String> commandRequests;
    private List<String> commandInputs;

    public Switcher(FlightController flightController, BookingController bookingController) {
        this.flightController = flightController;
        this.bookingController = bookingController;
    }

    public void execute(){
        switch (command) {
            case MAIN_MENU: printMainMenu(); break;
            case BOARD: printBoard(); break;
            case FLIGHT_INFO: break;
            case BOOK_FLIGHT: break;
            case CANCEL_BOOKING: break;
            case MY_FLIGHTS: break;
            case EXIT: break;
        }
    }

    public void execute(Commands command){
        this.command = command;
        this.execute();
    }

    public  Map<String, String> getRequests(Commands command){
        this.command = command;
        this.commandRequests = new HashMap<>();
        switch (command) {
            case FLIGHT_INFO: this.commandRequests = flightController.getFlightInfoRequests(); break;
//            case BOOK_FLIGHT: this.commandRequests = flightController.getSearchRequests(); break;
//            case CANCEL_BOOKING: this.commandRequests = bookingController.getCancelRequests(); break;
//            case MY_FLIGHTS: this.commandRequests = flightController.getFlightRequests(); break;
        }
        return this.commandRequests;
    }

    public void setCommandInputs(List<String> inputs){
        this.commandInputs = inputs;
    }

    //Question: whose responsibility is to print main menu
    private void printMainMenu(){

    }

    private void printBoard(){
        //flightController.printFlights();
    }





}
