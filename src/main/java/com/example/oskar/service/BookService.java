package com.example.oskar.service;

import com.example.oskar.entity.Book;
import com.example.oskar.repository.BookRepository;
import com.example.oskar.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private BookRepository bookRepository;
    private UserRepository userRepository;

    @Autowired
    public void getBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    public void getUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Logger logger = LoggerFactory.getLogger(BookService.class);

    public Book getBookByTitle(String title) {
        Optional<Book> optionalBook = bookRepository.findByTitle(title);
        return optionalBook.orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
//        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        UserEntity userEntity = userRepository.findByUsername(username).orElse(null);
//        if (userEntity == null) throw new RuntimeException("No user found");
//        logger.info("Bookservice user " + userEntity);
//        book.setUser_id(userEntity.getUser_id());
        logger.info("add book: " + book.getAuthors());
        book.setAuthors(book.getAuthors());
        return bookRepository.save(book);
    }

    public Book completeBook(Long id , Boolean complete) {
        Optional<Book> completeBook = bookRepository.findById(id);
        if (completeBook.isEmpty()) {
            return null;
        }
        completeBook.get().setRead(complete);
        logger.info("BookService " + completeBook.get().isRead());
        bookRepository.save(completeBook.get());
        return completeBook.get();
    }
}
