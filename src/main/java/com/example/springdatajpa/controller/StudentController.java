package com.example.springdatajpa.controller;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/students/{rno}")
    public Student getStudent(@PathVariable int rno) {
        return studentService.getStudentByRno(rno);
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student;
    }
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return student;
    }
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
}
