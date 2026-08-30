package com.example.petify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petify.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}