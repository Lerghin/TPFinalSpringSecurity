package com.lerdev.TrabajoFinalSpringSecurity.controller;

import com.lerdev.TrabajoFinalSpringSecurity.model.Post;
import com.lerdev.TrabajoFinalSpringSecurity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@PreAuthorize("isAuthenticated()")
public class PostRestController {
    @Autowired
    private PostService postService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_AUTHOR') ")
    public void findAll(){
        postService.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER') or hasRole('ROLE_AUTHOR')")
    public void findById(Long id){
        postService.findById(id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteById(Long id){
        postService.delete(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_AUTHOR') ")
    public void createPost(@RequestBody Post post){
        postService.save(post);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_AUTHOR')")
    public void update(@RequestBody Post post){
        postService.update (post);
    }

}
