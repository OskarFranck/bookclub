package com.example.oskar.controller;

import com.example.oskar.entity.Book;
import com.example.oskar.entity.UserEntity;
import com.example.oskar.model.CompleteBook;
import com.example.oskar.repository.UserRepository;
import com.example.oskar.service.BookService;
import com.example.oskar.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private UserRepository userRepository;
    private BookService bookService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void getBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void getUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/test")
    public String test() {
        logger.info("Hello");
        return "OK";
    }

    @GetMapping("/user/info")
    public UserEntity getUserDetails() {
        String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        logger.info("Apicontroller " + username);
        return userRepository.findByUsername(username).orElse(null);
    }

    @PostMapping(value = "/book/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        String test = userService.getUserId();
        logger.info(test);
        Book testBook = bookService.addBook(book);
        logger.info(testBook.getDescription() + testBook.getBook_id());
        return ResponseEntity.ok(testBook);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping(value = "/book/complete")
    public ResponseEntity<?> completeBook(@RequestBody CompleteBook body) {
        logger.info(String.valueOf(body.getBook_id()) + body.isRead());
        Book completeBook = bookService.completeBook(body.getBook_id(), body.isRead());
        return ResponseEntity.ok(completeBook);
    }

}
