package prink.flight.flightapi.service;

import org.springframework.stereotype.Service;
import prink.flight.flightapi.domain.SeatBookingDTO;
import prink.flight.flightapi.repository.adapter.BookingAdapter;
import prink.flight.flightapi.repository.adapter.SeatAdapter;

/**
 * BookingService klass vastutab broneeringute haldamise eest.
 */


 @Service
public class BookingService {
    private final BookingAdapter bookingAdapter;
    private final SeatAdapter seatAdapter;

    public BookingService(
            BookingAdapter bookingAdapter,
            SeatAdapter seatAdapter
    ) {

        this.bookingAdapter = bookingAdapter;
        this.seatAdapter = seatAdapter;
    }

    public SeatBookingDTO bookSeat(SeatBookingDTO seatBooking) {
        if (seatBooking.getSeatIds() == null || seatBooking.getSeatIds().isEmpty()) {
            throw new IllegalArgumentException("Seat IDs cannot be null or empty");
        }
        seatAdapter.setSeatsAvailable(seatBooking.getSeatIds(), false);

        return bookingAdapter.save(seatBooking);
    }

}