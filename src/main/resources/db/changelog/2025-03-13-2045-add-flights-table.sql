CREATE TABLE public.flight
(
    id          BIGSERIAL PRIMARY KEY,
    destination VARCHAR(255)             NOT NULL,
    departure   TIMESTAMP WITH TIME ZONE NOT NULL,
    arrival     TIMESTAMP WITH TIME ZONE NOT NULL,
    price       DOUBLE PRECISION         NOT NULL
);
