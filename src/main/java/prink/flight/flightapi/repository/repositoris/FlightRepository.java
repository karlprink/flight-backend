package prink.flight.flightapi.repository.repositoris;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import prink.flight.flightapi.repository.entity.Flight;


public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Flight findFlightById(Long flightId);

    @Query("SELECT f.price FROM Flight f WHERE f.id = :flightId")
    Double getFlightPriceById(@Param("flightId") Long flightId);}
