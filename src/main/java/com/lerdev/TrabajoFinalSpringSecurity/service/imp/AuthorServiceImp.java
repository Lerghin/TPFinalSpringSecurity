package com.lerdev.TrabajoFinalSpringSecurity.service.imp;

import com.lerdev.TrabajoFinalSpringSecurity.model.Author;
import com.lerdev.TrabajoFinalSpringSecurity.repository.IAuthorRepository;
import com.lerdev.TrabajoFinalSpringSecurity.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImp implements AuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Author> listAuthors() {
        return  authorRepository.findAll();
    }

    @Override
    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Author findAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author updateAuthor(Author author) {
        return authorRepository.save(author);
    }
}
