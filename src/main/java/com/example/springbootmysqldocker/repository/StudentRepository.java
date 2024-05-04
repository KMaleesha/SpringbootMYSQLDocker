package com.example.springbootmysqldocker.repository;

import com.example.springbootmysqldocker.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByEmail(String email);

}
