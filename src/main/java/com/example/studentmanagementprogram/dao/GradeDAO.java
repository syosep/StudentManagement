package com.example.studentmanagementprogram.dao;

import com.example.studentmanagementprogram.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    // 성적 추가
    public void addGrade(int studentId, String courseName, String grade, String semester) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO grades (student_id, course_name, grade, semester) VALUES (?,?,?,?)";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            ps.setString(2, courseName);
            ps.setString(3, grade);
            ps.setString(4, semester);
            ps.executeUpdate();
        }
    }

    // 특정 성적 조회 (학생 ID)
    public List<Grade> getGradesByStudentId(int studentId) throws SQLException {
        String sql = "SELECT * FROM grades WHERE student_id = ?";
        List<Grade> grades = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, studentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    grades.add(new Grade(
                            rs.getInt("id"),
                            rs.getInt("student_id"),
                            rs.getString("course_name"),
                            rs.getString("grade"),
                            rs.getString("semester")
                    ));
                }
            }
        }
        return grades;
    }

    // 특정 성적 삭제 (학생 ID)
    public void deleteGrade(int id) throws SQLException {
        String sql = "DELETE FROM grades WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
