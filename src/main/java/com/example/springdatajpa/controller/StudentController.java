package com.example.springdatajpa.controller;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }
//    Create
    @GetMapping("/students/{rno}")
    public Student getStudent(@PathVariable int rno) {
        return studentService.getStudentByRno(rno);
    }
//    add
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }

//    Update
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return student;
    }

//    Delete
    @DeleteMapping("/students/{rno}")
    public String deleteStudent(@PathVariable int rno) {
        studentService.deleteStudentByRno(rno);
        return "deleted";
    }

    @DeleteMapping("students/clear")
    public String deleteAllStudents() {
        studentService.deleteAllStudents();
        return "Deleted All Students";
    }

    //Method in Spring Data Jpa
    @GetMapping("/students/technology/{tech}")
    public List<Student> getStudentsByTechnology(@PathVariable("tech") String technology) {
        return studentService.getStudentsByTechnology(technology);
    }

//    Native Query
    @PostMapping("/students/filter")
    public List<Student> getStudentByGenderAndTechnology(@Param("gender") String gender,
                                                         @Param("technology") String technology) {
        return studentService.getStudentByGenderAndTechnology(gender, technology);
    }
}