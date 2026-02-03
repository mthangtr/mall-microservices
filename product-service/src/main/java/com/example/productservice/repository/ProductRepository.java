package com.example.productservice.repository;

import com.example.productservice.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductInfo, Long> {
    // Additional query methods can be defined here
}