package prink.flight.flightapi.service;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.Flight;
import prink.flight.flightapi.repository.FlightRepository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightService {
private FlightRepository flightRepository;
    public Flight getFlight(String flightId) {
        OffsetDateTime dateTime = OffsetDateTime.now();
        Flight flight = new Flight();
        return flight;
    }

    public List<Flight> getFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights;
    }
}
