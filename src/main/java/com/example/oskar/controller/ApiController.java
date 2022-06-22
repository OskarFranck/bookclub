package com.example.oskar.controller;

import com.example.oskar.entity.Author;
import com.example.oskar.entity.Book;
import com.example.oskar.entity.BookReview;
import com.example.oskar.entity.UserEntity;
import com.example.oskar.model.CompleteBook;
import com.example.oskar.repository.UserRepository;
import com.example.oskar.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    //TODO Add author service and endpoint
    //TODO Add review endpoint

    private UserRepository userRepository;
    private BookService bookService;
    private UserService userService;
    private ISBNService isbnService;
    private BookReviewService bookReviewService;
    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }
    @Autowired
    public void setIsbnService(ISBNService isbnService) {
        this.isbnService = isbnService;
    }
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
    @Autowired
    public void setBookReviewService(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
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
        if (isbnService.checkISBN(book.getISBN())) return ResponseEntity.badRequest().build();
//        String test = userService.getUserId();
//        logger.info(test);
        Book testBook = bookService.addBook(book);
        logger.info(testBook.getDescription() + testBook.getBook_id());
        return ResponseEntity.ok(testBook);
    }

    @GetMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @PutMapping(value = "/book/complete")
    public ResponseEntity<?> completeBook(@RequestBody CompleteBook body) {
        logger.info(String.valueOf(body.getBook_id()) + body.isRead());
        Book completeBook = bookService.completeBook(body.getBook_id(), body.isRead());
        return ResponseEntity.ok(completeBook);
    }
    @PostMapping("/review/create")
    public ResponseEntity<?> addBookReview(@RequestBody BookReview bookReview) {
        logger.info("Add Review: " + bookReview);
        BookReview review = bookReviewService.addBookReview(bookReview);
        return ResponseEntity.ok(review);
    }

    @PostMapping("/author/add")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        logger.info("Add Author " + author);

        Author newAuthor = authorService.addNewAuthor(author);
        return ResponseEntity.ok(newAuthor);
    }
}
