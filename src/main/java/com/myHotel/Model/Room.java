package com.myHotel.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;

    @Column(name = "Room_Name", nullable = false, unique = true)
    private String roomName;

    @Column(name = "Room_Price", nullable = false, unique = true)
    private  String roomPrice;

    @Column(name = "Room_Availability", nullable = false)
    private boolean roomAvail;



    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(String roomPrice) {
        this.roomPrice = roomPrice;
    }

    public boolean isRoomAvail() {
        return roomAvail;
    }

    public void setRoomAvail(boolean roomAvail) {
        this.roomAvail = roomAvail;
    }

    @Override
    public String toString() {
        return "Room { " +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", roomPrice='" + roomPrice + '\'' +
                ", roomAvail=" + roomAvail +
                '}';
    }
}
