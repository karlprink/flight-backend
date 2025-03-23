package prink.flight.flightapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class FlightsTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFlights_ShouldReturnOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/flights"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isArray());
    }

    @Test
    void getFlightById_ShouldReturnNotFound_WhenFlightDoesNotExist() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/flights/9999"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


}