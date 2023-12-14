package com.example.cinemaapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CinemaApp extends Application {
    private Screen screen;
    private User currentUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Cinema App");

        this.screen = new Screen(10, 17);
        this.currentUser = new User("Jan Kowalski");

        GridPane grid = new GridPane();

        for (Row row : screen.getRows()) {
            for (Seat seat : row.getSeats()) {
                Button seatButton = new Button("Row " + seat.getRow() + " Seat " + seat.getNumber());
                seatButton.setMinSize(100, 50);
                grid.add(seatButton, seat.getNumber() - 1, seat.getRow() - 1);

                seatButton.setOnAction(event -> {
                    if (seat.isReserved()) {
                        currentUser.unreserveSeat(seat);
                        seatButton.setStyle(""); // Clear seat style to indicate an available seat.
                    } else {
                        currentUser.reserveSeat(seat);
                        seatButton.setStyle("-fx-background-color: #FF0000;"); // Red color indicates a reserved seat.
                    }
                });
            }
        }

        Scene scene = new Scene(grid, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
