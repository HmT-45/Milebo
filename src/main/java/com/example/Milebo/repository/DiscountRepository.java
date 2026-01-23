package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository
        extends JpaRepository<Discount, String> {
}
