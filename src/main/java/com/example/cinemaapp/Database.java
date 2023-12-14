package com.example.cinemaapp;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users;
    private List<Seat> seats;

    public Database() {
        this.users = new ArrayList<>();
        this.seats = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
    }

}
