package com.example.milebo.feature.home.service;

import com.example.milebo.feature.home.dto.CategoryHomeBlock;
import com.example.milebo.feature.product.model.Product;
import com.example.milebo.feature.category.repository.CategoryRepository;
import com.example.milebo.feature.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UIControllerService {

    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

    public List<CategoryHomeBlock> getHomeBlocks() {

        return categoryRepo.findAllActive()
                .stream()
                .map(category -> {

                    List<Product> products =
                            productRepo.findTop6ByCategory(
                                    category.getId(),
                                    PageRequest.of(0, 6)
                            );

                    return new CategoryHomeBlock(category, products);
                })
                .toList();
    }
}
