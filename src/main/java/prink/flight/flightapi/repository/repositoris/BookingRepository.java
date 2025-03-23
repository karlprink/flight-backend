package prink.flight.flightapi.repository.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import prink.flight.flightapi.repository.entity.SeatBooking;

public interface BookingRepository extends JpaRepository<SeatBooking, Long> {

}
