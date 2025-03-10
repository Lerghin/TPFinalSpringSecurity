package com.lerdev.TrabajoFinalSpringSecurity.service;

import com.lerdev.TrabajoFinalSpringSecurity.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll();
    Post findById(Long id);
    Post findByTittle(String tittle);
    void save(Post post);
    void delete(Long id);
    Post update(Post post);
}
