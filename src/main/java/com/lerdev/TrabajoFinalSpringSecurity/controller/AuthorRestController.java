package com.lerdev.TrabajoFinalSpringSecurity.controller;

import com.lerdev.TrabajoFinalSpringSecurity.model.Author;
import com.lerdev.TrabajoFinalSpringSecurity.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/author")
@PreAuthorize("isAuthenticated()")
public class AuthorRestController {
    @Autowired
    private AuthorService authorService;


    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_AUTHOR')")
    public void findAll(){
        authorService.listAuthors();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_AUTHOR')")
    public void findById(Long id){
        authorService.findAuthorById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void createAuthor(@RequestBody Author author){
        authorService.saveAuthor(author);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(Long id){
        authorService.deleteAuthor(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') ")
    public void update(@RequestBody Author author){
        authorService.updateAuthor(author);
    }

}
