package com.example.cinemaapp;

import com.example.cinemaapp.Seat;
import com.example.cinemaapp.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    // Database connection details for MySQL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/cinema_db";
    private static final String DB_USER = "your_username";
    private static final String DB_PASSWORD = "your_password";

    private Connection connection; // Connection object to interact with the database
    private List<User> users;
    private List<Seat> seats;

    public Database() {
        this.users = new ArrayList<>();
        this.seats = new ArrayList<>();
        initializeDatabase();
    }

    // Initialize the database connection
    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            createTables(); // Create tables if they don't exist
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create tables if they don't exist
    private void createTables() {
        // Implement table creation queries here using SQL for MySQL
        // Example: Creating a Users table
        String createUserTableSQL = "CREATE TABLE IF NOT EXISTS Users (id INT AUTO_INCREMENT PRIMARY KEY, username VARCHAR(50), email VARCHAR(50))";
        try {
            connection.createStatement().executeUpdate(createUserTableSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {
        // Add user to the database (MySQL)
        // Implement INSERT query here to add user details into the Users table for MySQL
        // Example: "INSERT INTO Users (username, email) VALUES (?, ?)"
        // Use PreparedStatement to prevent SQL injection
        // Set parameters using PreparedStatement
        // Execute the query using PreparedStatement.executeUpdate()
        // Add the user to the 'users' list as well
        this.users.add(user);
    }

    public void addSeat(Seat seat) {
        this.seats.add(seat);
        // Add seat to the database (MySQL)
        // Similar to addUser, implement an INSERT query for the Seats table for MySQL
    }
}
