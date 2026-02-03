package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Product, Long> {
    // Additional query methods can be defined here
}