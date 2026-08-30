package com.example.petify.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "o_id")
    private int id;

    @Column(name = "o_date")
    private LocalDate oDate;

    @Column(name = "o_price")
    private double oPrice;

    @Column(name = "o_status")
    private String oStatus;

    @Column(name = "o_time")
    private LocalTime oTime;

    @Column(name = "u_id")
    private int userId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "username")
    private String username;

    @Column(name = "payment_status")
    private String paymentStatus;

    // GETTERS & SETTERS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public LocalDate getoDate() { return oDate; }
    public void setoDate(LocalDate oDate) { this.oDate = oDate; }

    public double getoPrice() { return oPrice; }
    public void setoPrice(double oPrice) { this.oPrice = oPrice; }

    public String getoStatus() { return oStatus; }
    public void setoStatus(String oStatus) { this.oStatus = oStatus; }

    public LocalTime getoTime() { return oTime; }
    public void setoTime(LocalTime oTime) { this.oTime = oTime; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(double totalPrice) { this.totalPrice = totalPrice; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}