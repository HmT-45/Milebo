package com.example.milebo.feature.inventory.admin;

import com.example.milebo.feature.inventory.dto.InventoryAdjustRequest;
import com.example.milebo.feature.inventory.model.InventoryType;
import com.example.milebo.feature.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/inventory")
@RequiredArgsConstructor
public class InventoryAdminController {

    private final InventoryService inventoryService;

    @PostMapping("/import")
    public void importStock(
            @RequestBody InventoryAdjustRequest req
    ) {
        inventoryService.adjustStock(
                req.getProductId(),
                req.getQuantity(),
                InventoryType.IMPORT,
                req.getReason()
        );
    }

    @PostMapping("/export")
    public void exportStock(
            @RequestBody InventoryAdjustRequest req
    ) {
        inventoryService.adjustStock(
                req.getProductId(),
                req.getQuantity(),
                InventoryType.EXPORT,
                req.getReason()
        );
    }
}
