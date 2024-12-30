package com.squidco.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.squidco.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    // configures JPA to generate all crud methods on that class <[class], [id type]>
}
