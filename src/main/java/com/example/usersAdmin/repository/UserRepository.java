package com.example.usersAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usersAdmin.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
