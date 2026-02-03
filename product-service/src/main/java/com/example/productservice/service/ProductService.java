package com.example.productservice.service;

import com.example.productservice.model.ProductInfo;
import com.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductInfo> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<ProductInfo> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public ProductInfo createProduct(ProductInfo productInfo) {
        return productRepository.save(productInfo);
    }

    public ProductInfo updateProduct(Long id, ProductInfo productInfo) {
        productInfo.setId(id);
        return productRepository.save(productInfo);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}