package com.example.studentdetails.service;

import com.example.studentdetails.dao.StudentDao;
import com.example.studentdetails.entites.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    public Student getStudent(Integer studentId) {
        Student student = studentDao.getStudent(studentId);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    public Integer createStudent(Student student) {
        Integer studentId = studentDao.createStudent(student);
        return studentId;
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        studentDao.deleteStudent(studentId);
    }
}
