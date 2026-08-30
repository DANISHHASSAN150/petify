package com.example.petify.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.petify.entity.Orders;
import com.example.petify.repository.OrdersRepository;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    // ================= CONSTRUCTOR =================
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    // ================= SAVE ORDER =================
    public Orders saveOrder(String username, double total) {

        Orders order = new Orders();

        order.setUsername(username);
        order.setTotalPrice(total);
        order.setOrderDate(LocalDate.now());
        order.setPaymentStatus("PENDING");

        return ordersRepository.save(order);
    }

    // ================= GET USER ORDERS =================
    public List<Orders> getOrdersByUser(String username) {

        return ordersRepository.findByUsername(username);
    }

    // ================= GET ALL ORDERS =================
    public List<Orders> getAllOrders() {

        return ordersRepository.findAll();
    }

    // ================= UPDATE ORDER STATUS =================
    public void updateOrderStatus(int id, String status) {

        Orders order = ordersRepository.findById(id).orElse(null);

        if (order == null) {
            throw new RuntimeException(
                "Order not found with ID: " + id
            );
        }

        order.setPaymentStatus(status);

        ordersRepository.save(order);
    }
}