package prink.flight.flightapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {
    private long id;
    private long flightId;
    private String seatNumber;
    private String seatClass;
    private boolean isCloseToWindow;
    private boolean isBusinessClass;
    private boolean extraLegRoom;
    private boolean closeToExit;
    private double price;
    private boolean available;
}
