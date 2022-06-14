package com.example.oskar.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Author {
    @Id
    private Long author_id;
    private String firstName;
    private String lastName;
    private String nationality;
    @ManyToMany(mappedBy = "book_id")
    private ArrayList<Book> book_id;
}
