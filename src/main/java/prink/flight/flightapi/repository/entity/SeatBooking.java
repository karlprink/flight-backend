package prink.flight.flightapi.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;
    private String passengerName;

    @ElementCollection
    @CollectionTable(name = "seat_booking_seats", joinColumns = @JoinColumn(name = "seat_booking_id"))
    @Column(name = "seat_id")
    private List<Long> seatIds;
}

