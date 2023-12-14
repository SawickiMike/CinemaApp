package com.example.cinemaapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CinemaApp extends Application {
    private int numRows = 10;
    private int seatsPerRow = 17;
    private Button[][] seats;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cinema App");

        GridPane grid = new GridPane();
        seats = new Button[numRows][seatsPerRow];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                seats[i][j] = new Button("Row " + (i + 1) + " Seat " + (j + 1));
                seats[i][j].setMinSize(100, 50);
                grid.add(seats[i][j], j, i);
                int row = i;
                int seat = j;
                seats[i][j].setOnAction(event -> toggleReservation(row, seat));
            }
        }

        Scene scene = new Scene(grid, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void toggleReservation(int row, int seat) {
        if (seats[row][seat].isDisabled()) {
            unreserveSeat(row, seat);
        } else {
            reserveSeat(row, seat);
        }
    }

    private void reserveSeat(int row, int seat) {
        System.out.println("Reserved seat: Row " + (row + 1) + " Seat " + (seat + 1));
        seats[row][seat].setDisable(true);
        seats[row][seat].setStyle("-fx-background-color: #FF0000;"); // Red color indicates a reserved seat.
    }

    private void unreserveSeat(int row, int seat) {
        System.out.println("Cancelled reservation: Row " + (row + 1) + " Seat " + (seat + 1));
        seats[row][seat].setDisable(false);
        seats[row][seat].setStyle(""); // Clear seat style to indicate an available seat.
    }
}
