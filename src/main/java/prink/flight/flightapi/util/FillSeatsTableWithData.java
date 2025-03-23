package prink.flight.flightapi.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * See klass kontrollib andmebaasi tühjust, kui see on tühi siis täidetakse relatsioon seats andmetega.
 * Suurem osa klassist loodud AI-ga, kuid tingimused mille põhjal istme parameetreid väärtusatatakse on muudetud.
 */
public class FillSeatsTableWithData {
    private static final String[] SEAT_CLASSES = {"Business", "Economy"};
    private static final String[] SEAT_PATTERN = {"A", "B", "C", "D", "E"};
    private static final Random RANDOM = new Random();

    public static void fillSeats(Connection connection) throws SQLException {
        String checkTableQuery = "SELECT COUNT(*) FROM public.seat";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkTableQuery);
             ResultSet resultSet = checkStmt.executeQuery()) {
            if (resultSet.next() && resultSet.getInt(1) > 0) {
                System.out.println("Seat table is not empty. Skipping data insertion.");
                return;
            }
        }

        String getFlightsQuery = "SELECT id FROM public.flight";
        String insertSeatQuery = "INSERT INTO public.seat " +
                "(flight_id, seat_number, seat_class, is_close_to_window, is_business_class, extra_leg_room, " +
                "close_to_exit, price, available) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement flightStmt = connection.prepareStatement(getFlightsQuery);
             PreparedStatement seatStmt = connection.prepareStatement(insertSeatQuery);
             ResultSet flights = flightStmt.executeQuery()) {

            while (flights.next()) {
                long flightId = flights.getLong("id");
                int seatNum = 1;

                for (int seat = 1; seat <= 100; seat++) {
                    boolean isBusinessClass = seatNum <= 4;
                    int letterIdx = (seat - 1) % 5;
                    String seatLabel = seatNum + SEAT_PATTERN[letterIdx];

                    boolean isCloseToWindow = (letterIdx == 0 || letterIdx == 4);
                    boolean extraLegRoom = isBusinessClass || seatNum == 10;
                    boolean closeToExit = (seatNum == 1 || seatNum == 20);
                    double price = isBusinessClass ? 200.0 : 0.0;
                    boolean available = RANDOM.nextBoolean();

                    seatStmt.setLong(1, flightId);
                    seatStmt.setString(2, seatLabel);
                    seatStmt.setString(3, isBusinessClass ? SEAT_CLASSES[0] : SEAT_CLASSES[1]);
                    seatStmt.setBoolean(4, isCloseToWindow);
                    seatStmt.setBoolean(5, isBusinessClass);
                    seatStmt.setBoolean(6, extraLegRoom);
                    seatStmt.setBoolean(7, closeToExit);
                    seatStmt.setDouble(8, price);
                    seatStmt.setBoolean(9, available);
                    seatStmt.addBatch();

                    if (letterIdx == 4) {
                        seatNum++;
                    }
                }
                seatStmt.executeBatch();
            }
            System.out.println("Seats table filled successfully.");
        }
    }
}
