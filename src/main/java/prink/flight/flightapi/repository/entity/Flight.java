package prink.flight.flightapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.OffsetDateTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String airline;
    private String aircraftModel;
    private String origin;
    private String destination;
    private java.time.OffsetDateTime departure;
    private java.time.OffsetDateTime arrival;
    private String gate;
    private int totalSeats;
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getAircraftModel() {
        return aircraftModel;
    }

    public void setAircraftModel(String aircraftModel) {
        this.aircraftModel = aircraftModel;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public OffsetDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(OffsetDateTime departure) {
        this.departure = departure;
    }

    public OffsetDateTime getArrival() {
        return arrival;
    }

    public void setArrival(OffsetDateTime arrival) {
        this.arrival = arrival;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", airline='" + airline + '\'' +
                ", aircraftModel='" + aircraftModel + '\'' +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", gate='" + gate + '\'' +
                ", totalSeats=" + totalSeats +
                ", price=" + price +
                '}';
    }
}
