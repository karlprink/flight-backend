package prink.flight.flightapi.repository;

import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.domain.SeatDTO;
import prink.flight.flightapi.repository.entity.Flight;
import prink.flight.flightapi.repository.entity.Seat;

public class FlightMapper {

    public static FlightDTO toFlightDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flight.getId());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setAircraftModel(flight.getAircraftModel());
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setDeparture(flight.getDeparture());
        flightDTO.setArrival(flight.getArrival());
        flightDTO.setGate(flight.getGate());
        flightDTO.setTotalSeats(flight.getTotalSeats());
        flightDTO.setPrice(flight.getPrice());
        return  flightDTO;
    }

    public static SeatDTO toSeatDTO(Seat seat) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.setId(seat.getId());
        seatDTO.setFlightId(seat.getFlightId());
        seatDTO.setSeatNumber(seat.getSeatNumber());
        seatDTO.setSeatClass(seat.getSeatClass());
        seatDTO.setCloseToWindow(seat.isCloseToWindow());
        seatDTO.setBusinessClass(seat.isBusinessClass());
        seatDTO.setExtraLegRoom(seat.isExtraLegRoom());
        seatDTO.setCloseToExit(seat.isCloseToExit());
        seatDTO.setPrice(seat.getPrice());
        seatDTO.setAvailable(seat.isAvailable());
        return seatDTO;
    }

    public static Flight toFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setId(flightDTO.getId());
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setAirline(flightDTO.getAirline());
        flight.setAircraftModel(flightDTO.getAircraftModel());
        flight.setOrigin(flightDTO.getOrigin());
        flight.setDestination(flightDTO.getDestination());
        flight.setDeparture(flightDTO.getDeparture());
        flight.setArrival(flightDTO.getArrival());
        flight.setGate(flightDTO.getGate());
        flight.setTotalSeats(flightDTO.getTotalSeats());
        flight.setPrice(flightDTO.getPrice());
        return flight;
    }

    public static Seat toSeat(SeatDTO seatDTO) {
        Seat seat = new Seat();
        seat.setId(seatDTO.getId());
        seat.setFlightId(seatDTO.getFlightId());
        seat.setSeatNumber(seatDTO.getSeatNumber());
        seat.setSeatClass(seatDTO.getSeatClass());
        seat.setCloseToWindow(seatDTO.isCloseToWindow());
        seat.setBusinessClass(seatDTO.isBusinessClass());
        seat.setExtraLegRoom(seatDTO.isExtraLegRoom());
        seat.setCloseToExit(seatDTO.isCloseToExit());
        seat.setPrice(seatDTO.getPrice());
        seat.setAvailable(seatDTO.isAvailable());
        return seat;
    }
}
