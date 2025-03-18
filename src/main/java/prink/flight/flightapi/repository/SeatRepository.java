package prink.flight.flightapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prink.flight.flightapi.repository.entity.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findAllByFlightId(long flightId);
}
