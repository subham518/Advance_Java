package com.example.task_manager.controller;

import com.example.task_manager.TokenUtil;
import com.example.task_manager.model.Task;
import com.example.task_manager.model.User;
import com.example.task_manager.repository.TaskRepository;
import com.example.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private TaskRepository repo;

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping
    public Object createNote(
            @RequestBody Task task,
            @RequestHeader("Authorization") String token) {

        String username = tokenUtil.validateToken(token);

        if (username == null) {
            return "Unauthorized";
        }
        task.setUsername(username);
        return repo.save(task);
    }

    @GetMapping
    public Object getTasks(@RequestHeader("Authorization") String token){

        String username = tokenUtil.validateToken(token);

        if(username == null) {
            return "Unauthorized";
        }

        return repo.findByUsername(username);
    }

    @GetMapping("/admin")
    public Object getAllTasks(@RequestHeader("AuthoriZation")String token){

        String username = tokenUtil.validateToken(token);
        if (username == null){
            return "Unauthorized";
        }

        User user = userRepo.findByUsername(username);
        if(!user.getRole().equals("ADMIN")){
            return "Access Denied";
        }

        return repo.findAll();
    }

    @PutMapping()


}
