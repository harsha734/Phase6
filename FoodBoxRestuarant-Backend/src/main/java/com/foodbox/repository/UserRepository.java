package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodbox.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
