package com.example.Milebo.repository;

import com.example.Milebo.model.BillDetails;
import com.example.Milebo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, String> {
}
