package prink.flight.flightapi.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class SeatBookingRequest {
    @NotNull(message = "Seat IDs cannot be null")
    @NotEmpty(message = "Seat IDs cannot be empty")
    private List<Long> seatIds;

    @NotNull(message = "Flight ID cannot be null")
    private Long flightId;

    @NotNull(message = "Passenger name cannot be null")
    @NotEmpty(message = "Passenger name cannot be empty")
    private String passengerName;
}
