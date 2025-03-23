package prink.flight.flightapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import prink.flight.flightapi.repository.adapter.SeatAdapter;
import prink.flight.flightapi.repository.repositoris.FlightRepository;
import prink.flight.flightapi.repository.repositoris.SeatRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeatsTest {

    @Mock
    private SeatRepository seatRepository;

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private SeatAdapter seatAdapter;



    @Test
    void testCalculateTotalPrice() {
        Long flightId = 1L;
        List<Long> seatIds = Arrays.asList(1L, 2L);
        Double flightPrice = 500.0;
        Double seatPrice = 200.0;

        when(flightRepository.getFlightPriceById(flightId)).thenReturn(flightPrice);
        when(seatRepository.getSeatPriceById(anyLong())).thenReturn(seatPrice);

        double totalPrice = seatAdapter.calculateTotalPrice(flightId, seatIds);

        assertEquals(1400.0, totalPrice);
        verify(flightRepository, times(1)).getFlightPriceById(flightId);
        verify(seatRepository, times(2)).getSeatPriceById(anyLong());
    }

}
