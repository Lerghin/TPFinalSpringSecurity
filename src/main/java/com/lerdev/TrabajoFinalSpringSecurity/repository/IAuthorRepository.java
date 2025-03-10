package com.lerdev.TrabajoFinalSpringSecurity.repository;

import com.lerdev.TrabajoFinalSpringSecurity.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
