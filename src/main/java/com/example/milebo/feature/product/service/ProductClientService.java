package com.example.milebo.feature.product.service;

import com.example.milebo.feature.product.model.Product;
import com.example.milebo.feature.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductClientService {

    private final ProductRepository productRepo;

    public List<Product> getActiveProducts() {
        return productRepo.findAllActive();
    }

    public List<Product> getActiveProductsByCategory(String code) {
        return productRepo.findActiveByCategoryCode(code);
    }


}

