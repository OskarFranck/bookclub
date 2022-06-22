package com.example.oskar.repository;

import com.example.oskar.entity.BookReview;
import com.example.oskar.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {
    Optional<BookReview> findByUser(UserEntity user);
}
