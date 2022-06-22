package com.example.oskar.service;

import com.example.oskar.entity.BookReview;
import com.example.oskar.model.ReviewInputModel;
import com.example.oskar.repository.BookRepository;
import com.example.oskar.repository.BookReviewRepository;
import com.example.oskar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReviewService {
    private BookReviewRepository bookReviewRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private ReviewInputModel reviewInputModel;

    @Autowired
    public void setReviewInputModel(ReviewInputModel reviewInputModel) {
        this.reviewInputModel = reviewInputModel;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Autowired
    public void setBookReviewRepository(BookReviewRepository bookReviewRepository) {
        this.bookReviewRepository = bookReviewRepository;
    }

    public BookReview addBookReview(BookReview bookReview) {
        return bookReview;
    }

    public ReviewInputModel createNewReview(ReviewInputModel reviewInputModel) {
        return reviewInputModel;
    }
}
