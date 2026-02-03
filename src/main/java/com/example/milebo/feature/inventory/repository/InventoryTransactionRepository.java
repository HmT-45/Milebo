package com.example.milebo.feature.inventory.repository;

import com.example.milebo.feature.inventory.model.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransactionRepository
        extends JpaRepository<InventoryTransaction, Long> {
}
