package com.example.studentmanagementprogram.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// MariaDB와 연결을 관리할 클래스
public class DBConnection {
    private static final String URL = "jdbc:mariadb://walab.handong.edu:3306/OSS24_22100423";
    private static final String USER = "OSS24_22100423";
    private static final String PASSWORD = "nieJo3ch";

    public static Connection getConnection() throws SQLException {
        try {
            // MariaDB 드라이버 로드
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("DB Driver not found", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
