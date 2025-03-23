package prink.flight.flightapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatBookingDTO {
    private Long id;
    private Long flightId;
    private String passengerName;
    private List<Long> seatIds;

}
