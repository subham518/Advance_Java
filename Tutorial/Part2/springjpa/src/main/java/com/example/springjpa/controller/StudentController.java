package com.example.springjpa.controller;


import com.example.springjpa.model.Student;
import com.example.springjpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repo;

    public StudentController(StudentRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return repo.save(student);
    }

    @GetMapping
    public List<Student> getStudent(){
        return repo.findAll();
    }
}
