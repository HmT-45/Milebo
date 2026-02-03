package com.example.milebo.feature.product.service;

import com.example.milebo.feature.product.dto.ProductCreateRequest;
import com.example.milebo.feature.product.dto.ProductUpdateRequest;
import com.example.milebo.feature.category.model.Category;
import com.example.milebo.feature.product.model.Product;
import com.example.milebo.feature.category.repository.CategoryRepository;
import com.example.milebo.feature.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepo;
    private final CategoryRepository categoryRepo;
    private final CloudinaryService cloudinaryService;

    // Admin xem tất cả (kể cả inactive)
    public List<Product> findAll() {
        return productRepo.findAllForAdmin();
    }
    public Product findById(Long id) {
        return productRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sản phẩm không tồn tại"));
    }
    /* ================= CREATE ================= */

    public void create(ProductCreateRequest dto) {

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));

        if (!Boolean.TRUE.equals(category.getStatus())) {
            throw new IllegalArgumentException("Không được chọn danh mục INACTIVE");
        }

        String imageUrl = cloudinaryService.uploadImage(dto.getImageFile());

        Product p = new Product();
        p.setName(dto.getName().trim());
        p.setDescription(dto.getDescription());
        p.setImage(imageUrl);
        p.setPrice(dto.getPrice());
        p.setQuantity(dto.getQuantity());
        p.setCategory(category);
        p.setStatus(dto.getStatus());
        p.setCode(generateCode(dto.getName()));

        productRepo.save(p);
    }

    /* ================= UPDATE ================= */

    public void update(ProductUpdateRequest dto) {

        Product p = productRepo.findById(dto.getId())
                .orElseThrow(() -> new IllegalArgumentException("Sản phẩm không tồn tại"));

        Category category = categoryRepo.findById(dto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Danh mục không tồn tại"));

        if (Boolean.TRUE.equals(dto.getStatus()) && !Boolean.TRUE.equals(category.getStatus())) {
            throw new IllegalArgumentException(
                    "Không thể ACTIVE sản phẩm trong danh mục INACTIVE"
            );
        }

        if (dto.getImageFile() != null && !dto.getImageFile().isEmpty()) {
            String newImage = cloudinaryService.uploadImage(dto.getImageFile());
            p.setImage(newImage);
        }

        p.setName(dto.getName().trim());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());
        p.setQuantity(dto.getQuantity());
        p.setCategory(category);
        p.setStatus(dto.getStatus());

        productRepo.save(p);
    }


    /* ================= CODE GENERATOR ================= */

    private String generateCode(String name) {

        String normalized = Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .replace("Đ", "D")
                .replace("đ", "d");

        String base = "PROD_" + normalized
                .replaceAll("[^a-zA-Z0-9]", "_")
                .toUpperCase();

        String code = base;
        int i = 1;

        while (productRepo.existsByCode(code)) {
            code = base + "_" + i++;
        }
        return code;
    }

}


