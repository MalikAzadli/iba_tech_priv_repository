package step_project_sketch;

import step_project_sketch.model.Booking;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingService {
    private final BookingDAO data;

    public BookingService(BookingDAO file) {
        data = file;
        data.load();
    }

    public Set<Booking> findAllBookings() {
        return data.findAll();
    }

    public List<Booking> findAllBookingsOf(int passengerId) {
        return data.findAll().stream().filter(b -> b.getUser().getId() == 1).collect(Collectors.toList());
    }

    public Booking createBooking(String flightNo, String clientName) {
        return null;
    }

    public void cancelBooking(int id) { }
}
