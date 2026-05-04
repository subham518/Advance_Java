package com.example.notepadcopy.controller;

import com.example.notepadcopy.TokenUtil;
import com.example.notepadcopy.model.Note;
import com.example.notepadcopy.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository repo;

    @Autowired
    private TokenUtil tokenUtil;

    @PostMapping
    public Object createNote(
            @RequestBody Note note,
            @RequestHeader("Authorization") String token) {

        String username = tokenUtil.validateToken(token);

        if (username == null) {
            return "Unauthorized";
        }
        note.setUsername(username);
        return repo.save(note);
    }

    @GetMapping
    public Object getNotes(@RequestHeader("Authorization") String token){

        String username = tokenUtil.validateToken(token);

        if(username == null) {
            return "Unauthorized";
        }

        return repo.findByUsername(username);
    }

}