package com.example.springdatajpa.reposiroty;
import java.util.List;
import com.example.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>
{
    //Method in Spring Data Jpa
    List<Student> findByTechnology(String technology);
}
