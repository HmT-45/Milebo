package com.example.milebo.feature.category.dto;

import lombok.Data;



@Data
public class CategoryUpdateRequest {
    private long id;
    private String name;
    private Boolean status;
}

