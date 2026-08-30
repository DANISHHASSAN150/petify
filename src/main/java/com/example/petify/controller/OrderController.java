package com.example.petify.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petify.entity.Orders;
import com.example.petify.service.OrdersService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrdersService ordersService;

    // Constructor Injection
    public OrderController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    // ================= PLACE ORDER =================
    @PostMapping("/place")
    public String placeOrder(
            @RequestBody List<Map<String, Object>> cart,
            @RequestParam String username) {

        if (cart == null || cart.isEmpty()) {
            return "Cart is empty";
        }

        if (username == null || username.trim().isEmpty()) {
            return "Invalid Username";
        }

        double total = 0;

        for (Map<String, Object> item : cart) {

            if (item == null) {
                continue;
            }

            Object priceObj = item.get("price");

            if (priceObj != null) {
                try {
                    total += Double.parseDouble(priceObj.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price: " + priceObj);
                }
            }
        }

        ordersService.saveOrder(username.trim(), total);

        return "Order Placed Successfully!";
    }

    // ================= USER ORDERS =================
    @GetMapping("/my")
    public List<Orders> getUserOrders(
            @RequestParam String username) {

        return ordersService.getOrdersByUser(username);
    }

    // ================= ADMIN - ALL ORDERS =================
    @GetMapping("/admin/all")
    public List<Orders> getAllOrders() {

        return ordersService.getAllOrders();
    }

    // ================= ADMIN - UPDATE STATUS =================
    @PutMapping("/admin/update/{id}")
    public String updateStatus(
            @PathVariable int id,
            @RequestParam String status) {

        if (status == null || status.trim().isEmpty()) {
            return "Invalid Status";
        }

        ordersService.updateOrderStatus(
                id,
                status.trim()
        );

        return "Order Status Updated";
    }
}