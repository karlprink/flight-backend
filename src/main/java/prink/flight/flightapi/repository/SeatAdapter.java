package prink.flight.flightapi.repository;

import org.springframework.stereotype.Component;
import prink.flight.flightapi.domain.SeatDTO;
import prink.flight.flightapi.repository.entity.Seat;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeatAdapter {

    private final SeatRepository seatRepository;

    public SeatAdapter(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<SeatDTO> getSeatsByFlightId(Long flightId) {
        List<Seat> seats = seatRepository.findAllByFlightId(flightId);
        return seats.stream().map(FlightMapper::toSeatDTO).collect(Collectors.toList());
    }
}
