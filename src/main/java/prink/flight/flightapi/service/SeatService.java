package prink.flight.flightapi.service;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.SeatDTO;
import prink.flight.flightapi.repository.SeatAdapter;

import java.util.List;

@Component
public class SeatService {
    private final SeatAdapter seatAdapter;

    public SeatService(SeatAdapter seatAdapter) {
        this.seatAdapter = seatAdapter;
    }

    public List<SeatDTO> getSeatsByFlightId(Long flightId) {
        return seatAdapter.getSeatsByFlightId(flightId);
    }
}
