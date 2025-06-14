package com.example.springdatajpa.reposiroty;
import java.util.List;
import com.example.springdatajpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    //Method in Spring Data Jpa
    List<Student> findByTechnology(String technology);

// Native Query
   @Query(value = "SELECT * FROM student WHERE gender = :gender AND technology = :technology", nativeQuery = true)
    List<Student> findByGenderAndTechnology(@Param("gender") String gender,
                                            @Param("technology") String technology);
}
