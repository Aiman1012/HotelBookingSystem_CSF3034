package com.myHotel.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int reservationId;
    public Date checkInDate;
    public Date checkOutDate;
    public String roomType;
    public int numOfGuests;

    public Reservation() {
    }

    public Reservation(int reservationId, Date checkInDate, Date checkOutDate, String roomType, int numOfGuests) {
        this.reservationId = reservationId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomType = roomType;
        this.numOfGuests = numOfGuests;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", roomType='" + roomType + '\'' +
                ", numOfGuests=" + numOfGuests +
                '}';
    }
}
