package com.example.Spring_MVC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/students")
    public String students (Model model){

        model.addAttribute("name", "Subham");
        model.addAttribute("course", "Spring Boot");

        return "students";
    }
}
