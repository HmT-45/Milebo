package com.example.milebo.feature.inventory.service;

import com.example.milebo.feature.inventory.model.Inventory;
import com.example.milebo.feature.inventory.model.InventoryTransaction;
import com.example.milebo.feature.inventory.model.InventoryType;
import com.example.milebo.feature.inventory.repository.InventoryRepository;
import com.example.milebo.feature.inventory.repository.InventoryTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepo;
    private final InventoryTransactionRepository transactionRepo;

    @Transactional
    public void adjustStock(
            Long productId,
            int quantity,
            InventoryType type,
            String reason
    ) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity phải > 0");
        }

        Inventory inventory =
                inventoryRepo.findByProductIdForUpdate(productId);

        if (inventory == null) {
            throw new RuntimeException("Inventory không tồn tại");
        }

        if (type == InventoryType.EXPORT
                && inventory.getQuantity() < quantity) {
            throw new RuntimeException("Không đủ hàng trong kho");
        }

        int delta = (type == InventoryType.IMPORT)
                ? quantity
                : -quantity;

        inventory.setQuantity(inventory.getQuantity() + delta);

        transactionRepo.save(
                new InventoryTransaction(
                        productId,
                        type,
                        quantity,
                        reason
                )
        );
    }
}


