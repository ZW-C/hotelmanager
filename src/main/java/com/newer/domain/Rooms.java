package com.newer.domain;

import java.io.Serializable;

public class Rooms implements Serializable {

    private Integer roomid;
    private String roomtype;
    private Double price;
    private String state;

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Rooms() {
    }

    public Rooms(Integer roomid, String roomtype, Double price, String state) {
        this.roomid = roomid;
        this.roomtype = roomtype;
        this.price = price;
        this.state = state;
    }
}
