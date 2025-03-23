package prink.flight.flightapi.repository.repositoris;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import prink.flight.flightapi.repository.entity.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findAllByFlightId(Long flightId);
    Seat findSeatById(Long seatId);


    @Modifying
    @Transactional
    @Query("UPDATE Seat s SET s.available = :available WHERE s.id IN :seatIds")
    void markSeatsAvailability(@Param("seatIds") List<Long> seatIds, @Param("available") Boolean available);


    @Query("SELECT s.price FROM Seat s WHERE s.id = :seatId")
    Double getSeatPriceById(@Param("seatId") Long seatId);
}