package com.example.milebo.feature.discount.repository;

import com.example.milebo.feature.discount.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository
        extends JpaRepository<Discount, String> {
}

