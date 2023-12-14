package com.example.cinemaapp;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private List<Row> rows;

    public Screen(int numberOfRows, int seatsPerRow) {
        this.rows = new ArrayList<>();
        for (int i = 0; i < numberOfRows; i++) {
            this.rows.add(new Row(i + 1, seatsPerRow));
        }
    }

    public List<Row> getRows() {
        return this.rows;
    }
}
