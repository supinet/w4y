package com.w4you.inventoryservice.repository;

import com.w4you.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySku(final String sku);

    Set<Inventory> findBySkuIn(final Set<String> skus);
}
