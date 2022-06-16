package com.example.oskar.service;

import com.example.oskar.entity.Book;
import com.example.oskar.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class ISBNService {
    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public boolean checkISBN(String ISBN) {
        Book book = bookRepository.findByISBN(ISBN).orElse(null);
        return book != null;
    }
}
