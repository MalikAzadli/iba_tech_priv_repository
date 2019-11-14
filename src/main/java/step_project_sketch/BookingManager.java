package step_project_sketch;

import java.util.*;
import java.util.stream.Collectors;

public class BookingManager {

    private final Console console;
    private final Database database;
    private Switcher switcher;
    private final Map<String, Commands> commands;
    private final InputChecker checker;

    public BookingManager(Console console, Database database) {
        this.console = new SystemConsole();
        this.database = new Database();
        FlightController flightController = new FlightController(new FlightService(new FlightDAO()));
        BookingController bookingController = new BookingController(new BookingService(new BookingDAO()));
        this.switcher = new Switcher(flightController, bookingController);
        this.checker = new InputChecker(flightController, bookingController);
        this.commands = new HashMap<>();

        List<Commands> commandNames = Arrays.stream(Commands.values()).collect(Collectors.toList());
        commandNames.forEach(c -> commands.put(String.format("%d", commandNames.indexOf(c)), c));
    }

    public void run() {
        String line = "";
        do {
            switcher.execute(Commands.MAIN_MENU);
            line = console.readLn();
            Commands command = commands.get(line);
            Map<String, String> commandRequests = switcher.getRequests(command);
            List<String> commandInputs = getCommandInputs(commandRequests);
            switcher.setCommandInputs(commandInputs);
            switcher.execute();
        } while (!line.equalsIgnoreCase(Commands.EXIT.toString()));
    }


    public List<String> getCommandInputs(Map<String, String> requests) {
        ArrayList<String> inputs = new ArrayList<>();
        requests.keySet().forEach(o -> {
            String input = "";
            boolean flag = true;
            while (flag && input.equalsIgnoreCase(String.valueOf(Commands.EXIT))) {
                console.print(o);
                input = console.readLn();
                if (checker.check(input, requests.get(o))) {
                    inputs.add(input);
                    flag = false;
                }
            }
        });
        return inputs;
    }
}
