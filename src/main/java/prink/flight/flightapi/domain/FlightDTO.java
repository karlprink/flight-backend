package prink.flight.flightapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    private Long id;
    private String flightNumber;
    private String airline;
    private String aircraftModel;
    private String origin;
    private String destination;
    private OffsetDateTime departure;
    private OffsetDateTime arrival;
    private String gate;
    private int totalSeats;
    private double price;

}
