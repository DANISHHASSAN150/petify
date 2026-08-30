package com.example.petify.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int p_id;

    private double p_amount;
    private String p_refund;
    private String p_status;
    private int o_id;

    // GETTERS & SETTERS

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public double getP_amount() {
        return p_amount;
    }

    public void setP_amount(double p_amount) {
        this.p_amount = p_amount;
    }

    public String getP_refund() {
        return p_refund;
    }

    public void setP_refund(String p_refund) {
        this.p_refund = p_refund;
    }

    public String getP_status() {
        return p_status;
    }

    public void setP_status(String p_status) {
        this.p_status = p_status;
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }
}