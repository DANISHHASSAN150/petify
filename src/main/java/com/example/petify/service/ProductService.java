package com.example.petify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.petify.entity.Product;
import com.example.petify.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // ================= CONSTRUCTOR =================
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ================= ADD / UPDATE PRODUCT =================
    public Product addProduct(Product product) {

        return productRepository.save(product);
    }

    // ================= GET ALL PRODUCTS =================
    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    // ================= GET PRODUCT BY ID =================
    public Product getById(int id) {

        return productRepository.findById(id).orElse(null);
    }

    // ================= DELETE PRODUCT =================
    public void deleteProduct(int id) {

        if (!productRepository.existsById(id)) {
            throw new RuntimeException(
                "Product not found with ID: " + id
            );
        }

        productRepository.deleteById(id);
    }
}