INSERT INTO public.flight (flight_number, airline, aircraft_model, origin, destination, departure, arrival,gate, total_seats, price) VALUES

                                                                                                                                    ('FL1001', 'Air France', 'Boeing 737', 'Tallinn', 'Paris', '2025-04-01 08:00:00+02', '2025-04-01 10:30:00+02','A1', 100, 200),
                                                                                                                                    ('FL1002', 'Lufthansa', 'Airbus A320', 'Tallinn', 'Berlin', '2025-04-02 09:15:00+02', '2025-04-02 10:45:00+02', 'A2', 100, 180),
                                                                                                                                    ('FL1003', 'British Airways', 'Boeing 777', 'Tallinn', 'London', '2025-04-03 12:00:00+02', '2025-04-03 14:30:00+02', 'B1', 100, 250),
                                                                                                                                    ('FL1004', 'Emirates', 'Airbus A380', 'Tallinn', 'Dubai', '2025-04-04 14:00:00+02', '2025-04-04 22:00:00+04', 'C3', 100, 500),
                                                                                                                                    ('FL1005', 'Turkish Airlines', 'Boeing 737', 'Tallinn', 'Istanbul', '2025-04-05 06:30:00+02', '2025-04-05 10:00:00+03', 'D2', 100, 220),
                                                                                                                                    ('FL1006', 'Finnair', 'Embraer 190', 'Tallinn', 'Helsinki', '2025-04-06 07:00:00+02', '2025-04-06 07:45:00+02', 'A1', 100, 150),
                                                                                                                                    ('FL1007', 'SAS', 'Airbus A320', 'Tallinn', 'Stockholm', '2025-04-07 08:00:00+02', '2025-04-07 09:30:00+02', 'B4', 100, 170),
                                                                                                                                    ('FL1008', 'KLM', 'Boeing 737', 'Tallinn', 'Amsterdam', '2025-04-08 10:30:00+02', '2025-04-08 12:30:00+02', 'C5', 100, 200),
                                                                                                                                    ('FL1009', 'Norwegian', 'Boeing 737', 'Tallinn', 'Oslo', '2025-04-09 11:00:00+02', '2025-04-09 12:30:00+02', 'D3', 100, 180),
                                                                                                                                    ('FL1010', 'Ryanair', 'Boeing 737', 'Tallinn', 'Dublin', '2025-04-10 13:00:00+02', '2025-04-10 15:30:00+01', 'A4', 100, 160),
                                                                                                                                    ('FL1011', 'Wizz Air', 'Airbus A321', 'Tallinn', 'Warsaw', '2025-04-11 14:45:00+02', '2025-04-11 16:15:00+02', 'B2', 100, 140),
                                                                                                                                    ('FL1012', 'EasyJet', 'Airbus A320', 'Tallinn', 'Milan', '2025-04-12 15:30:00+02', '2025-04-12 18:00:00+02', 'C1', 100, 190),
                                                                                                                                    ('FL1013', 'Qatar Airways', 'Boeing 787', 'Tallinn', 'Doha', '2025-04-13 16:00:00+02', '2025-04-13 23:30:00+03', 'D4', 100, 600),
                                                                                                                                    ('FL1014', 'Singapore Airlines', 'Airbus A350', 'Tallinn', 'Singapore', '2025-04-14 18:00:00+02', '2025-04-15 12:00:00+08', 'B5', 100, 700),
                                                                                                                                    ('FL1015', 'American Airlines', 'Boeing 777', 'Tallinn', 'New York', '2025-04-15 20:00:00+02', '2025-04-16 04:00:00-04', 'C2', 100, 550);

DO $$
DECLARE
flight_id BIGINT := 1; -- Replace with your actual flight ID
    seat_classes TEXT[] := ARRAY['Business', 'Economy'];
    seat_pattern TEXT[] := ARRAY['A', 'B', 'C', 'D', 'E'];
    is_business_class BOOLEAN;
    seat_num INTEGER := 1;
    letter_idx INTEGER;
BEGIN
FOR i IN 1..100 LOOP
        is_business_class := i <= 20;

        -- Determine seat number and letter
        letter_idx := MOD(i - 1, 5) + 1;

INSERT INTO public.seat
(flight_id, seat_number, seat_class, is_close_to_window, is_business_class, extra_leg_room, close_to_exit, price, available)
VALUES (
           flight_id,
           seat_num || seat_pattern[letter_idx],
           seat_classes[CASE WHEN is_business_class THEN 1 ELSE 2 END],
           letter_idx IN (1, 5), -- Close to window for A or E
           is_business_class,
           is_business_class,  -- Extra legroom for business class
           letter_idx IN (1, 5), -- Assume close to exit for window seats
           CASE WHEN is_business_class THEN 200.0 ELSE 100.0 END, -- Example pricing
           RANDOM() > 0.5
       );

-- Increment seat number after cycling through A-E
IF letter_idx = 5 THEN
            seat_num := seat_num + 1;
END IF;
END LOOP;
END $$;
