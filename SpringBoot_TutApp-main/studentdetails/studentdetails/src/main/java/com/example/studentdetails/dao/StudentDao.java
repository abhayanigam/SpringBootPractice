package com.example.studentdetails.dao;

import com.example.studentdetails.entites.Student;

import java.util.List;

public interface StudentDao {
    public Student getStudent(Integer studentId);

    public void deleteStudent(Integer studentId);

    public void updateStudent(Student student);

    public Integer createStudent(Student student);

    List<Student> getStudents();
}
