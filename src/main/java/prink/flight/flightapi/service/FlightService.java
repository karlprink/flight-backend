package prink.flight.flightapi.service;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.repository.entity.Flight;
import prink.flight.flightapi.repository.FlightAdapter;

import java.time.OffsetDateTime;
import java.util.List;

@Component
public class FlightService {
    private final FlightAdapter flightAdapter;

    public FlightService(FlightAdapter flightAdapter) {
        this.flightAdapter = flightAdapter;
    }

    public Flight getFlight(String flightId) {
        OffsetDateTime dateTime = OffsetDateTime.now();
        Flight flight = new Flight();
        return flight;
    }

    public List<FlightDTO> getFlights() {
        return flightAdapter.findAll();
    }
}
