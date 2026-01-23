package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository
        extends JpaRepository<Review, String> {
}
