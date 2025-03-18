package prink.flight.flightapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prink.flight.flightapi.domain.Flight;


public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
