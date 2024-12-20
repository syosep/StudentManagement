package com.example.studentmanagementprogram.model;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date birthDate;
    private String major;
    private String status;

    public Student(int id, String name, Date birthDate, String major, String status) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.major = major;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
