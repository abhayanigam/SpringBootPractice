package com.example.studentdetails.service;

import com.example.studentdetails.entites.Student;

import java.util.List;

public interface StudentService {

    Student getStudent(Integer studentId);

    List<Student> getStudents();

    Integer createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Integer studentId);
}
