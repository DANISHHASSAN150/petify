package com.example.petify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petify.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByLoginNameAndPassword(String loginName, String password);
}