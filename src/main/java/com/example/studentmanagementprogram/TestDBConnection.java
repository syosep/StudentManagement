package com.example.studentmanagementprogram;

import com.example.studentmanagementprogram.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        try (Connection connection = DBConnection.getConnection()) {
            if (connection != null) {
                System.out.println("Successfully connected to MariaDB");
            }
        } catch (SQLException e) {
            System.err.println("Failed to connect to MariaDB" + e.getMessage());
        }
    }
}
