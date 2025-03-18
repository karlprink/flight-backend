package prink.flight.flightapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.domain.SeatDTO;
import prink.flight.flightapi.service.FlightService;
import prink.flight.flightapi.service.SeatService;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;
    private final SeatService seatService;

    public FlightController(FlightService flightService, SeatService seatService) {
        this.flightService = flightService;
        this.seatService = seatService;
    }

    // Kõikide lendude toomine (lihtne GET /api/flights)
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getFlights();
    }

    @GetMapping("/{flightId}/seats")
    public ResponseEntity<List<SeatDTO>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<SeatDTO> seats = seatService.getSeatsByFlightId(flightId);
        return ResponseEntity.ok(seats);
    }
}
