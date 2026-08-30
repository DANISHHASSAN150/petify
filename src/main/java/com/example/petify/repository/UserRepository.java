package com.example.petify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.petify.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLoginNameAndPassword(String loginName, String password);
    User findByLoginName(String loginName);
}