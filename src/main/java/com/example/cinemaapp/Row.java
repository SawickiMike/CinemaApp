package com.example.cinemaapp;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Seat> seats;
    private int rowNumber;

    public Row(int rowNumber, int numberOfSeats) {
        this.rowNumber = rowNumber;
        this.seats = new ArrayList<>();
        for (int i = 0; i < numberOfSeats; i++) {
            this.seats.add(new Seat(rowNumber, i + 1));
        }
    }

    public List<Seat> getSeats() {
        return this.seats;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }
}
