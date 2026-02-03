package com.example.milebo.feature.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryAdjustRequest {
    private Long productId;
    private int quantity;
    private String reason;
}

