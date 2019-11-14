package step_project_sketch;

public class Application {

    public static void main(String[] args) {
        Console console = new SystemConsole();
        Database database = new Database();
        BookingManager app = new BookingManager(console, database);
        app.run();
    }
}
