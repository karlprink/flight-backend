package prink.flight.flightapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.repository.entity.Flight;
import prink.flight.flightapi.repository.entity.Seat;
import prink.flight.flightapi.repository.FlightRepository;
import prink.flight.flightapi.repository.SeatRepository;
import prink.flight.flightapi.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    private final FlightRepository flightRepository;
    private final SeatRepository seatRepository;

    public FlightController(FlightService flightService, FlightRepository flightRepository, SeatRepository seatRepository) {
        this.flightService = flightService;
        this.flightRepository = flightRepository;
        this.seatRepository = seatRepository;
    }

    // Kõikide lendude toomine (lihtne GET /api/flights)
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getFlights();
    }

    // Lennu toomine ID järgi (GET /api/flights/{flightId})
    @GetMapping("/{flightId}")
    public ResponseEntity<Object> getFlightById(@PathVariable String flightId) {
        Flight flight = flightService.getFlight(flightId);
        return ResponseEntity.ok(flight);
    }
    @GetMapping("/{SeatsByFlightId}")
public List<Seat> getSeatsByFlightId(@PathVariable String SeatsByFlightId) {
        Seat seat =
        return seatRepository.findAllByFlightId(Long.parseLong(SeatsByFlightId));
}
}
