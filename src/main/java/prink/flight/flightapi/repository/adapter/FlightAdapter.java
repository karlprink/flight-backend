package prink.flight.flightapi.repository.adapter;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.repository.FlightMapper;
import prink.flight.flightapi.repository.entity.Flight;
import prink.flight.flightapi.repository.repositoris.FlightRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * FlightAdapter klass vastutab lennu andmete haldamise eest
 */
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

    @Transactional(readOnly = true)
    public FlightDTO getFlightById(Long flightId) {
        Optional<Flight> flightOpt = Optional.ofNullable(flightRepository.findFlightById(flightId));

        // Kui lendu ei eksisteeri, viskab erindi
        Flight flight = flightOpt.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found"));

        return FlightMapper.toFlightDTO(flight);
    }

}