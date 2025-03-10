package com.lerdev.TrabajoFinalSpringSecurity.service;

import com.lerdev.TrabajoFinalSpringSecurity.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> listAuthors();
    Author findAuthorById(Long id);
    Author findAuthorByName(String name);
    void saveAuthor(Author author);
    void deleteAuthor(Long id);
    Author updateAuthor(Author author);
}
