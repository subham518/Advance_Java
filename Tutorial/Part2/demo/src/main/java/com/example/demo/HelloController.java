package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This class handles HTTP requests equivalent  to : @Controller + @ResponseBofy

public class HelloController {

    @GetMapping("/")
    public String home(){
        return "Welcome to Spring Boot";
    }
    @GetMapping("/about")
    public String about(){
        System.out.println("about endpoint triggered!!");
        return "This is about page";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        System.out.println("dashboard endpoint triggered!!");
        return "This is dashboard page";
    }
}
