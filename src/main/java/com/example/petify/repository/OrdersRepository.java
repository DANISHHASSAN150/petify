package com.example.petify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petify.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
    List<Orders> findByUsername(String username);
}