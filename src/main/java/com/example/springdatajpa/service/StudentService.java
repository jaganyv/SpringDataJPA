package com.example.springdatajpa.service;

import com.example.springdatajpa.model.Student;
import com.example.springdatajpa.reposiroty.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;
    public List<Student> getStudents() {
     return studentRepo.findAll();
    }

    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    public Student getStudentByRno(int rno) {
        return studentRepo.findById(rno).orElse(new Student());
    }

    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    public void deleteStudentByRno(int rno) {
        studentRepo.deleteById(rno);
    }

    public void deleteAllStudents() {
        studentRepo.deleteAll();
    }

    //Method in Spring Data Jpa
    public List<Student> getStudentsByTechnology(String technology) {
        return studentRepo.findByTechnology(technology);
    }

    public List<Student> getStudentByGenderAndTechnology(String gender, String technology) {
        return studentRepo.findByGenderAndTechnology(gender, technology);
    }
}
