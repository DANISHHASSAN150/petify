package com.example.petify.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.petify.entity.Admin;
import com.example.petify.repository.AdminRepository;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    private final AdminRepository adminRepository;

    // Constructor Injection
    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // ================= ADMIN LOGIN =================
    @PostMapping("/login")
    public String login(@RequestBody Admin admin) {

        // Check empty request
        if (admin == null ||
            admin.getLoginName() == null ||
            admin.getPassword() == null ||
            admin.getLoginName().trim().isEmpty() ||
            admin.getPassword().trim().isEmpty()) {

            return "Invalid Credentials";
        }

        // Find admin from database
        Admin existingAdmin =
                adminRepository.findByLoginNameAndPassword(
                        admin.getLoginName().trim(),
                        admin.getPassword().trim()
                );

        // Login successful
        if (existingAdmin != null) {
            return "Admin Login Success";
        }

        // Login failed
        return "Invalid Credentials";
    }
}