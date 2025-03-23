package prink.flight.flightapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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