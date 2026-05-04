package com.example.task_manager.controller;

import com.example.task_manager.TokenUtil;
import com.example.task_manager.model.User;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private TaskRepository taskRepo;

    @PostMapping("/register")
    public String register(@RequestBody User user){
        repo.save(user);
        return "Registered!!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        User dbUser = repo.findByUsername(user.getUsername());

        if(dbUser != null && dbUser.getPassword().equals(user.getPassword())){
            return tokenUtil.generateToken(user.getUsername());
        }
        return "Invalid!!";
    }

    @DeleteMapping()
}
