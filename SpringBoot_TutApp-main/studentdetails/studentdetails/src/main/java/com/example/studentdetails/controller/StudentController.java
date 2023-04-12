package com.example.studentdetails.controller;

import com.example.studentdetails.entites.Student;
import com.example.studentdetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(
        path = "/studentservice/v1/students",
        produces = "application/json",
        consumes = "application/json"
)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId){
        Student var = studentService.getStudent(studentId);
        if (var == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    String.format("Student with identifier %d does not exists", studentId));
        }
        return var;
    }

    @GetMapping
    public List<Student> getStudents(){
        List<Student> students = studentService.getStudents();
        return students;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        Integer id = studentService.createStudent(student);
        Student var = studentService.getStudent(id);
        if (var == null){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Student could not be created due to bad request");
        }
        return var;
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable("studentId") Integer studentId,@RequestBody Student student){
        student.setId(studentId);
        studentService.updateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable ("studentId") Integer studentId){
        studentService.deleteStudent(studentId);
    }
}
