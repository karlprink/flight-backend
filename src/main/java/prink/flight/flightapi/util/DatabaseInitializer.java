package prink.flight.flightapi.util;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * See meetod täidab tühja andmebaasi.
 */
@Component
public class DatabaseInitializer {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initDatabase() {
        try (Connection connection = jdbcTemplate.getDataSource().getConnection()) {
            FillSeatsTableWithData.fillSeats(connection);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
