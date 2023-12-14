package com.example.cinemaapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Seat> reservedSeats;

    public User(String name) {
        this.name = name;
        this.reservedSeats = new ArrayList<>();
    }

    public void reserveSeat(Seat seat) {
        seat.reserve();
        reservedSeats.add(seat);
    }

    public void unreserveSeat(Seat seat) {
        seat.unreserve();
        reservedSeats.remove(seat);
    }
}
