package prink.flight.flightapi.repository.adapter;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import prink.flight.flightapi.domain.SeatDTO;
import prink.flight.flightapi.repository.FlightMapper;
import prink.flight.flightapi.repository.entity.Seat;
import prink.flight.flightapi.repository.repositoris.FlightRepository;
import prink.flight.flightapi.repository.repositoris.SeatRepository;

import java.util.List;
import java.util.stream.Collectors;
/**
 * SeatAdapter klass vastutab istmete andmete haldamise eest.
 */
 @Component
public class SeatAdapter {

    private final SeatRepository seatRepository;
    private final FlightRepository flightRepository;

    public SeatAdapter(SeatRepository seatRepository, FlightRepository flightRepository) {
        this.seatRepository = seatRepository;
        this.flightRepository = flightRepository;
    }

    @Transactional(readOnly = true)
    public List<SeatDTO> getSeatsByFlightId(Long flightId) {
        List<Seat> seats = seatRepository.findAllByFlightId(flightId);
        return seats.stream().map(FlightMapper::toSeatDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SeatDTO getSeatById(Long seatId) {
        Seat seat = seatRepository.findSeatById(seatId);
        return FlightMapper.toSeatDTO(seat);
    }

    @Transactional
    public List<SeatDTO> setSeatsAvailable(List<Long> seatIds, Boolean available) {
        seatRepository.markSeatsAvailability(seatIds, available);
        List<Seat> seats = seatRepository.findAllById(seatIds);
        return seats.stream().map(FlightMapper::toSeatDTO).collect(Collectors.toList());
    }


    @Transactional
    public double calculateTotalPrice(Long flightId, List<Long> seatIds) {
        double totalPrice = 0.0;

        Double flightPrice = flightRepository.getFlightPriceById(flightId);  // Lennu hind

        if (flightPrice == null) {
            throw new IllegalArgumentException("No price found for flight: " + flightId);
        }

        for (Long seatId : seatIds) {
            Double seatPrice = seatRepository.getSeatPriceById(seatId);

            if (seatPrice != null) {
                totalPrice += seatPrice;  // Istme hind
            } else {
                throw new IllegalArgumentException("No price for seat: " + seatId);
            }
        }

        totalPrice += flightPrice * seatIds.size();  // Lennu hind * valitud istmete arv

        return totalPrice;
    }
}