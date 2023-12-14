package com.example.cinemaapp;

import java.time.LocalDateTime;

public class Reservation {
    private User user;
    private Seat seat;
    private LocalDateTime reservationTime;

    public Reservation(User user, Seat seat) {
        this.user = user;
        this.seat = seat;
        this.reservationTime = LocalDateTime.now();
    }

    public User getUser() {
        return this.user;
    }

    public Seat getSeat() {
        return this.seat;
    }

    public LocalDateTime getReservationTime() {
        return this.reservationTime;
    }
}
