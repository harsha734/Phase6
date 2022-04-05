package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.pojo.NonVeg;

@Repository
public interface NonVegRepository extends JpaRepository<NonVeg, Integer> {

}
