package com.example.springbootmysqldocker.service;

import com.example.springbootmysqldocker.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public String deleteStudent(int id);
    public Optional<Student> getOneStudent(int id);
    public Student login(String email, String password);
}
