package prink.flight.flightapi.repository.adapter;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.SeatBookingDTO;
import prink.flight.flightapi.repository.entity.SeatBooking;
import prink.flight.flightapi.repository.repositoris.BookingRepository;

/**
 * Klass mis salvestab broneeringu andmed.
 */

@Component
public class BookingAdapter {

    private final BookingRepository bookingRepository;

    public BookingAdapter(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public SeatBookingDTO save(SeatBookingDTO seatBookingDTO) {
        SeatBooking seatBooking = new SeatBooking();
        seatBooking.setFlightId(seatBookingDTO.getFlightId());
        seatBooking.setPassengerName(seatBookingDTO.getPassengerName());
        seatBooking.setSeatIds(seatBookingDTO.getSeatIds());

        SeatBooking savedEntity = bookingRepository.save(seatBooking);

        return new SeatBookingDTO(
                savedEntity.getId(),
                savedEntity.getFlightId(),
                savedEntity.getPassengerName(),
                savedEntity.getSeatIds()
        );
    }

}