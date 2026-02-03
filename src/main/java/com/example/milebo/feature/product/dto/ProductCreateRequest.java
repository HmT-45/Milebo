package com.example.milebo.feature.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {

    private String code;

    private String description;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    // admin chọn category (CHỈ ACTIVE)
    private Long categoryId;

    // mặc định true khi tạo
    private Boolean status;

    private MultipartFile imageFile;
}

