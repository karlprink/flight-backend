package prink.flight.flightapi.service;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.repository.adapter.FlightAdapter;

import java.util.List;
/**
 * FlightService klass vastutab lennu andmete haldamise eest.
 */

 @Component
public class FlightService {
    private final FlightAdapter flightAdapter;

    public FlightService(FlightAdapter flightAdapter) {
        this.flightAdapter = flightAdapter;
    }

    public List<FlightDTO> getFlights() {
        return flightAdapter.findAll();
    }

    public FlightDTO getFlightById(Long flightId) {
        return flightAdapter.getFlightById(flightId);
    }
}
