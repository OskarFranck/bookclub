package com.example.oskar.model;

import com.example.oskar.entity.Author;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class BookModel {
    private String ISBN;
    private String title;
    private String description;
    private int release_year;
    private float rating;
    private List<Author> authors;
}
