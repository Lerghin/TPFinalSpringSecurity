package com.lerdev.TrabajoFinalSpringSecurity.repository;

import com.lerdev.TrabajoFinalSpringSecurity.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    Post findByTittle(String tittle);
}
