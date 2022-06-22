package com.example.oskar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long book_id;
    private String ISBN;
    private String title;
    private String description;
    private int release_year;
    private boolean read;
    private float rating;
    @ManyToMany(mappedBy = "books", cascade = CascadeType.PERSIST)
    private List<Author> authors;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<BookReview> reviews;
}
