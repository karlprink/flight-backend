package prink.flight.flightapi.service;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.SeatDTO;
import prink.flight.flightapi.repository.adapter.SeatAdapter;

import java.util.List;
/**
 * SeatService klass vastutab istmete andmete haldamise eest.
 */
@Component
public class SeatService {
    private final SeatAdapter seatAdapter;

    public SeatService(SeatAdapter seatAdapter) {
        this.seatAdapter = seatAdapter;
    }

    public List<SeatDTO> getSeatsByFlightId(Long flightId) {
        return seatAdapter.getSeatsByFlightId(flightId);
    }

    public SeatDTO getSeatById(Long seatId) {
        return seatAdapter.getSeatById(seatId);
    }


    public double calculateTotalPrice(Long flightId, List<Long> seatIds) {
        return  seatAdapter.calculateTotalPrice(flightId, seatIds);
    }
}