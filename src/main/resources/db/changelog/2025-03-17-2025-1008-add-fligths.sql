CREATE TABLE public.flight
(
    id             BIGSERIAL PRIMARY KEY,
    flight_number  VARCHAR(20)             NOT NULL UNIQUE,
    airline        VARCHAR(100)             NOT NULL,
    aircraft_model VARCHAR(50)              NOT NULL,
    origin         VARCHAR(255)             NOT NULL,
    destination    VARCHAR(255)             NOT NULL,
    departure      TIMESTAMP WITH TIME ZONE NOT NULL,
    arrival        TIMESTAMP WITH TIME ZONE NOT NULL,
    gate           VARCHAR(10)              NOT NULL,
    total_seats    INT NOT NULL DEFAULT 100,
    price          DOUBLE PRECISION         NOT NULL
);

CREATE TABLE public.seat
(
    id                BIGSERIAL PRIMARY KEY,
    flight_id         BIGINT NOT NULL REFERENCES public.flight(id) ON DELETE CASCADE,
    seat_number       VARCHAR(5) NOT NULL,
    seat_class        VARCHAR(15) NOT NULL CHECK (seat_class IN ('Business', 'Economy')),
    is_close_to_window BOOLEAN NOT NULL,
    is_business_class BOOLEAN NOT NULL,
    extra_leg_room    BOOLEAN NOT NULL,
    close_to_exit     BOOLEAN NOT NULL,
    price             DOUBLE PRECISION NOT NULL,
    available         BOOLEAN DEFAULT RANDOM() > 0.5
);


