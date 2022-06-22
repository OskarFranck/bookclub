package com.example.oskar.service;

import com.example.oskar.entity.Author;
import com.example.oskar.entity.Book;
import com.example.oskar.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    @Autowired
    public void setAuthorRepository(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author addNewAuthor(Author author) {
        if (author.getBooks() != null) {
            author.setBooks(author.getBooks());
        }
        return authorRepository.save(author);
    }


}
