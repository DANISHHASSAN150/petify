package com.example.petify.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.petify.entity.Product;
import com.example.petify.service.ProductService;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ProductService productService;

    // ================= CONSTRUCTOR =================
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ================= ADD PET =================
    @PostMapping("/admin/add")
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);
    }

    // ================= GET ALL PETS =================
    @GetMapping("/all")
    public List<Product> getAllProducts() {

        return productService.getAllProducts();
    }

    // ================= GET PET BY ID =================
    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {

        return productService.getById(id);
    }

    // ================= DELETE PET =================
    @DeleteMapping("/admin/delete/{id}")
    public String deletePet(@PathVariable int id) {

        Product product = productService.getById(id);

        if (product == null) {
            return "Product not found";
        }

        productService.deleteProduct(id);

        return "Deleted Successfully";
    }

    // ================= UPDATE PET =================
    @PutMapping("/admin/update/{id}")
    public Product updatePet(
            @PathVariable int id,
            @RequestBody Product product) {

        Product existingProduct = productService.getById(id);

        if (existingProduct == null) {
            throw new RuntimeException(
                    "Product not found with ID: " + id
            );
        }

        existingProduct.setType(product.getType());
        existingProduct.setBreed(product.getBreed());
        existingProduct.setGender(product.getGender());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStatus(product.getStatus());
        existingProduct.setImage(product.getImage());

        return productService.addProduct(existingProduct);
    }
}