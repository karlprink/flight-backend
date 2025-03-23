package prink.flight.flightapi.controller;

import jakarta.validation.Valid;
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

    /**
     * Toob kõik lennud (lihtne GET /api/flights).
     * @return List FlightDTO objektidest, mis sisaldavad kõiki lende.
     */
    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getFlights();
    }


    /**
     * Toob lennu ID järgi.
     * @param flightId Lennu ID.
     * @return FlightDTO objekt, mis sisaldab lennu andmeid.
     */
    @GetMapping("/{flightId}")
    public FlightDTO getFlightById(@PathVariable Long flightId) {
        FlightDTO flight = flightService.getFlightById(flightId);
        return ResponseEntity.ok(flight).getBody();
    }

    /**
     * Toob istmed lennu ID järgi.
     * @param flightId Lennu ID.
     * @return ResponseEntity, mis sisaldab Listi SeatDTO objektidest.
     */
    @GetMapping("/{flightId}/seats")
    public ResponseEntity<List<SeatDTO>> getSeatsByFlightId(@PathVariable Long flightId) {
        List<SeatDTO> seats = seatService.getSeatsByFlightId(flightId);
        return ResponseEntity.ok(seats);
    }

    /**
     * Toob istme ID järgi.
     * @param seatId Istme ID.
     * @return ResponseEntity, mis sisaldab SeatDTO objekti.
     */
    @GetMapping("/seats/{seatId}/seat")
    public ResponseEntity<SeatDTO> SeatBySeatId(@PathVariable Long seatId) {
        SeatDTO seat = seatService.getSeatById(seatId);
        return ResponseEntity.ok(seat);
    }
}


