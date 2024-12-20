package com.example.studentmanagementprogram.model;

public class Grade {
    private int id;
    private int studentId;
    private String courseName;
    private String grade;
    private String semester;

    public Grade(int id, int studentId, String courseName, String grade, String semester) {
        this.id = id;
        this.studentId = studentId;
        this.courseName = courseName;
        this.grade = grade;
        this.semester = semester;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }
}
