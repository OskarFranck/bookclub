package com.example.oskar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long review_id;
    @Lob
    private String text;
    @Basic
    private java.sql.Timestamp date_created;
    @Basic
    private java.sql.Timestamp date_modified;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
