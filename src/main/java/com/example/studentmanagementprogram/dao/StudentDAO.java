package com.example.studentmanagementprogram.dao;

import com.example.studentmanagementprogram.model.Student;
import com.example.studentmanagementprogram.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    // 학생 추가 CREATE
    public void addStudent(String name, Date birthDate, String major, String status) throws SQLException {
        String sql = "INSERT INTO students (name, birth_date, major, status) VALUES (?, ?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDate(2, birthDate);
            ps.setString(3, major);
            ps.setString(4, status);
            ps.executeUpdate();
        }
    }

    // 특정 학생 조회 (ID) READ
    public Student getStudentById(int id) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDate("birth_date"),
                            rs.getString("major"),
                            rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    // 모든 학생 조회 READ
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                students.add(new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("birth_date"),
                        rs.getString("major"),
                        rs.getString("status")
                ));
            }
        }
        return students;
    }

    // 학생 수정 UPDATE
    public void updateStudent(int id, String name, Date birthDate, String major, String status) throws SQLException {
        String sql = "UPDATE students SET name = ?, birth_date = ?, major = ?, status = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setDate(2, birthDate);
            ps.setString(3, major);
            ps.setString(4, status);
            ps.setInt(5, id);
            ps.executeUpdate();
        }
    }

    // 학생 삭제 DELETE
    public void deleteStudent(int id) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
