package prink.flight.flightapi.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long flightId;
    private String seatNumber;
    private String seatClass;
    private boolean isCloseToWindow;
    private boolean isBusinessClass;
    private boolean extraLegRoom;
    private boolean closeToExit;
    private double price;
    private boolean available;

    public Seat() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFlightId() {
        return flightId;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public boolean isCloseToWindow() {
        return isCloseToWindow;
    }

    public void setCloseToWindow(boolean closeToWindow) {
        isCloseToWindow = closeToWindow;
    }

    public boolean isBusinessClass() {
        return isBusinessClass;
    }

    public void setBusinessClass(boolean businessClass) {
        isBusinessClass = businessClass;
    }

    public boolean isExtraLegRoom() {
        return extraLegRoom;
    }

    public void setExtraLegRoom(boolean extraLegRoom) {
        this.extraLegRoom = extraLegRoom;
    }

    public boolean isCloseToExit() {
        return closeToExit;
    }

    public void setCloseToExit(boolean closeToExit) {
        this.closeToExit = closeToExit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public Seat(long id, long flightId, String seatNumber, String seatClass, boolean isCloseToWindow, boolean isBusinessClass, boolean extraLegRoom, boolean closeToExit, double price, boolean available) {
        this.id = id;
        this.flightId = flightId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isCloseToWindow = isCloseToWindow;
        this.isBusinessClass = isBusinessClass;
        this.extraLegRoom = extraLegRoom;
        this.closeToExit = closeToExit;
        this.price = price;
        this.available = available;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatClass='" + seatClass + '\'' +
                ", isCloseToWindow=" + isCloseToWindow +
                ", isBusinessClass=" + isBusinessClass +
                ", extraLegRoom=" + extraLegRoom +
                ", closeToExit=" + closeToExit +
                ", price=" + price +
                ", available=" + available +
                '}';
    }
}