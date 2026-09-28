package com.example.lostpetfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lostpetfinder.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
