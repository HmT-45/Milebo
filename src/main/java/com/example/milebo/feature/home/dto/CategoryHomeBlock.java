package com.example.milebo.feature.home.dto;

import com.example.milebo.feature.category.model.Category;
import com.example.milebo.feature.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryHomeBlock {
    private Category category;
    private List<Product> products;
}

