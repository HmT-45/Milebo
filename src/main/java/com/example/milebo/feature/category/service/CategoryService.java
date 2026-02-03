package com.example.milebo.feature.category.service;

import com.example.milebo.feature.category.dto.CategoryUpdateRequest;
import com.example.milebo.feature.category.model.Category;
import com.example.milebo.feature.category.repository.CategoryRepository;
import com.example.milebo.feature.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.text.Normalizer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
//  import
    private final CategoryRepository categoryRepo;
    private final ProductRepository productRepo;

//Khai báo các hàm find
    // find all
    public List<Category> findAll() {
                return categoryRepo.findAll();
    }
    // find all active
    public List<Category> findAllActive() {
                return categoryRepo.findAllActive();
    }
    // find by id
    public Category findById(Long id) {
        return categoryRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));
    }
    public void create(String name, Boolean status) {

        String cleanName = name.trim();

        if (categoryRepo.existsByNameIgnoreCase(cleanName)) {
            throw new IllegalArgumentException("Danh mục đã tồn tại");
        }

        Category c = new Category();
        c.setName(cleanName);
        c.setCode(generateCode(cleanName));
        c.setStatus(status);

        categoryRepo.save(c);
    }

    private String generateCode(String name) {
        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replace("Đ", "D")
                .replace("đ", "d");

        String base = "CAT_" + normalized
                .replaceAll("[^a-zA-Z0-9]", "_")
                .toUpperCase();

        String code = base;
        int i = 1;

        while (categoryRepo.existsByCode(code)) {
            code = base + "_" + i++;
        }
        return code;
    }

    public void update(CategoryUpdateRequest dto) {
        Category c = categoryRepo.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));
        String cleanName = dto.getName().trim();
        if (categoryRepo.existsByNameIgnoreCaseAndIdNot(cleanName, dto.getId())) {
            throw new IllegalArgumentException("Tên danh mục đã tồn tại");
        }
//  Chặn không được disable category khi category còn product
        c.setName(cleanName);
        if (!dto.getStatus() && productRepo.existsByCategoryId(dto.getId())) {
            throw new IllegalArgumentException("Danh mục đang được sử dụng, không thể ngừng hoạt động");
        }
        c.setStatus(dto.getStatus());
        categoryRepo.save(c);
    }
}

