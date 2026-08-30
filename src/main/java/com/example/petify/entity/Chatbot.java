package com.example.petify.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chatbot")
public class Chatbot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int c_id;

    private int chat_id;

    @Column(columnDefinition = "TEXT")
    private String c_question;

    @Column(columnDefinition = "TEXT")
    private String c_response;

    // GETTERS & SETTERS

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getChat_id() {
        return chat_id;
    }

    public void setChat_id(int chat_id) {
        this.chat_id = chat_id;
    }

    public String getC_question() {
        return c_question;
    }

    public void setC_question(String c_question) {
        this.c_question = c_question;
    }

    public String getC_response() {
        return c_response;
    }

    public void setC_response(String c_response) {
        this.c_response = c_response;
    }
}