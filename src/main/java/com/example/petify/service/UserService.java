package com.example.petify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.petify.entity.User;
import com.example.petify.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    // ================= CONSTRUCTOR =================
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ================= LOGIN =================
    public User login(String loginName, String password) {

        return userRepository.findByLoginNameAndPassword(
                loginName,
                password
        );
    }

    // ================= GET ALL USERS =================
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    // ================= GET USER BY ID =================
    public User getUserById(int id) {

        return userRepository.findById(id).orElse(null);
    }

    // ================= GET USER BY USERNAME =================
    public User getByLoginName(String loginName) {

        return userRepository.findByLoginName(loginName);
    }

    // ================= SAVE / UPDATE USER =================
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    // ================= DELETE USER =================
    public void deleteUser(int id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException(
                    "User not found with ID: " + id
            );
        }

        userRepository.deleteById(id);
    }
}