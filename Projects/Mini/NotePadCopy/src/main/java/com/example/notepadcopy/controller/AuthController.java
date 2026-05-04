package com.example.notepadcopy.controller;

import com.example.notepadcopy.TokenUtil;
import com.example.notepadcopy.model.User;
import com.example.notepadcopy.repository.NoteRepository;
import com.example.notepadcopy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private NoteRepository noteRepo;

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
}
