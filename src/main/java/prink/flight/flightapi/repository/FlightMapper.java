package prink.flight.flightapi.repository;

import prink.flight.flightapi.domain.FlightDTO;
import prink.flight.flightapi.repository.entity.Flight;

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
}
