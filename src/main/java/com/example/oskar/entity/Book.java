package com.example.oskar.entity;

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
    private String user_id;
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
    @ManyToMany(mappedBy = "books")
    private List<UserEntity> user;
}
