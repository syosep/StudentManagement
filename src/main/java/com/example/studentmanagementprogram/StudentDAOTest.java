package com.example.studentmanagementprogram;

import com.example.studentmanagementprogram.dao.StudentDAO;
import com.example.studentmanagementprogram.model.Student;

import java.sql.Date;
import java.util.List;

public class StudentDAOTest {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        try {
            // 학생 추가
            studentDAO.addStudent("홍길동", Date.valueOf("2000-01-01"), "컴퓨터공학", "재학");

            // 모든 학생 조회
            List<Student> students = studentDAO.getAllStudents();
            students.forEach(student -> System.out.println(student.getName()));

            // 특정 학생 조회
            Student student = studentDAO.getStudentById(1);
            if (student != null) {
                System.out.println("조회된 학생 : " + student.getName());
            }

            // 학생 수정
            studentDAO.updateStudent(1, "홍길순", Date.valueOf("1999-12-31"), "전자공학", "졸업");

            // 학생 삭제
            studentDAO.deleteStudent(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
