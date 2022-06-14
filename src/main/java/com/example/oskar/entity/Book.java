package com.example.oskar.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    @Id
    private Long book_id;
    private String title;
    private String description;
    private int release_year;
    private boolean read;
    private float rating;
    @ManyToMany(mappedBy = "author_id")
    private ArrayList<Author> authors;
}
