package prink.flight.flightapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prink.flight.flightapi.controller.request.SeatBookingRequest;
import prink.flight.flightapi.domain.SeatBookingDTO;
import prink.flight.flightapi.service.BookingService;
import prink.flight.flightapi.service.SeatService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flights")
public class BookingController {
    private final BookingService bookingService;
    private final SeatService seatService;

    public BookingController(BookingService bookingService, SeatService seatService) {
        this.bookingService = bookingService;
        this.seatService = seatService;
    }

    /**
     * Broneerib istmed antud lennule.
     * @param flightId Lennu ID.
     * @param request Päring, mis sisaldab reisija nime ja istmete ID-sid.
     * @return ResponseEntity, mis sisaldab broneeritud istmete andmeied.
     */
    @PostMapping("/{flightId}/seats/book")
    public ResponseEntity<?> bookSeats(@PathVariable Long flightId, @RequestBody @Valid SeatBookingRequest request) {
        SeatBookingDTO seatBooking = new SeatBookingDTO();

        seatBooking.setFlightId(flightId);
        seatBooking.setPassengerName(request.getPassengerName());
        seatBooking.setSeatIds(request.getSeatIds());


        SeatBookingDTO savedSeatBooking = bookingService.bookSeat(seatBooking);

        return ResponseEntity.ok(savedSeatBooking);
    }

    /**
     * Arvutab antud lennu valitud istmete koguhinna.
     * @param flightId Lennu ID.
     * @param requestBody Päringu keha, mis sisaldab istmete ID-sid.
     * @return ResponseEntity, mis sisaldab lennuhinda ja istmehinda.
     */
    @PostMapping("/{flightId}/seats/totalprice")
    public ResponseEntity<Map<String, Object>> calculateTotalPrice(@PathVariable Long flightId, @RequestBody Map<String, List<Long>> requestBody) {
        List<Long> seatIds = requestBody.get("seatIds");

        if (seatIds == null || seatIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("message", "Seat IDs are required"));
        }

        double totalPrice = seatService.calculateTotalPrice(flightId, seatIds);

        Map<String, Object> response = new HashMap<>();
        response.put("totalPrice", totalPrice);
        return ResponseEntity.ok(response);
    }

}

