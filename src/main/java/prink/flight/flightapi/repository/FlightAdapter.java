package prink.flight.flightapi.repository;


import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.repository.entity.Flight;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FlightAdapter {

    private final FlightRepository flightRepository;

    public FlightAdapter(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> findAll() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(FlightMapper::toFlightDTO).collect(Collectors.toList());
    }
}
