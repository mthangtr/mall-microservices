package com.example.inventoryservice.service;

import com.example.inventoryservice.model.Product;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Product> getAllProducts() {
        return inventoryRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return inventoryRepository.findById(id);
    }

    public Product addProduct(Product product) {
        return inventoryRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setStock(productDetails.getStock());
        return inventoryRepository.save(product);
    }

    public void deleteProduct(Long id) {
        inventoryRepository.deleteById(id);
    }

    public void updateStock(Long productId, int quantity) {
        Product product = inventoryRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setStock(product.getStock() - quantity);
        inventoryRepository.save(product);
    }
}