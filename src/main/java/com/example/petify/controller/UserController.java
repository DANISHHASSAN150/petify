package com.example.petify.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.petify.entity.User;
import com.example.petify.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    // ================= CONSTRUCTOR =================
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ================= LOGIN =================
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        if (user == null ||
            user.getLoginName() == null ||
            user.getPassword() == null) {

            return "Invalid Credentials";
        }

        User existingUser = userService.login(
                user.getLoginName(),
                user.getPassword()
        );

        if (existingUser != null) {
            return "Login Successful";
        }

        return "Invalid Credentials";
    }

    // ================= REGISTER USER =================
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    // ================= GET USER BY USERNAME =================
    @GetMapping("/by-username/{loginName}")
    public User getByLoginName(@PathVariable String loginName) {

        return userService.getByLoginName(loginName);
    }

    // ================= GET USER BY ID =================
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {

        return userService.getUserById(id);
    }

    // ================= GET ALL USERS =================
    @GetMapping("/all")
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // ================= DELETE USER =================
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {

        userService.deleteUser(id);

        return "User Deleted Successfully";
    }
}