package com.example.oskar.model;

import com.example.oskar.entity.Author;
import com.example.oskar.entity.Book;
import com.example.oskar.entity.BookReview;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Getter
@Setter
@Component
public class ReviewInputModel {
    private Author author;
    private Book book;
    private BookReview bookReview;
//    private String ISBN;
//    private String title;
//    private String description;
//    private int release_year;
//    private boolean read;
//    private float rating;
//    private String firstName;
//    private String lastName;
//    private String nationality;
}
