package com.example.milebo.feature.review.repository;

import com.example.milebo.feature.review.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository
        extends JpaRepository<Review, String> {
}

