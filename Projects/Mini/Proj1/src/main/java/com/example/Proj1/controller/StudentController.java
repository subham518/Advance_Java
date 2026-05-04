package com.example.Proj1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Proj1.entity.Student;
import com.example.Proj1.repository.StudentRepository;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository repo;

    @GetMapping("/")
    public String viewHome(Model model) {
        model.addAttribute("list", repo.findAll());
        return "index";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        repo.save(student);
        return "redirect:/";
    }
}