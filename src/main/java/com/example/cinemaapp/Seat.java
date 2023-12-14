package com.example.cinemaapp;

public class Seat {
    private int row;
    private int number;
    private boolean isReserved;

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.isReserved = false;
    }

    public void reserve() {
        this.isReserved = true;
    }

    public void unreserve() {
        this.isReserved = false;
    }

    public boolean isReserved() {
        return this.isReserved;
    }
}
