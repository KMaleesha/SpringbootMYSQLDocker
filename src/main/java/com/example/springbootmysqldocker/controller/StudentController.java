package com.example.springbootmysqldocker.controller;

import com.example.springbootmysqldocker.model.Student;
import com.example.springbootmysqldocker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping( "/save")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Successfully Saved Student detail.";
    }
    @GetMapping("/all_students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }
    @GetMapping("/{id}")
    public Optional<Student> getOneStudent(@PathVariable int id){
        return studentService.getOneStudent(id);
    }
    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Map<String, String> loginDetails) {
        String email = loginDetails.get("email");
        String password = loginDetails.get("password");

        Student student = studentService.login(email, password);
        if (student != null) {
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
