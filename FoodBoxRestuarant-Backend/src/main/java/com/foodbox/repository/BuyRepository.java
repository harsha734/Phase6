package com.foodbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.pojo.Buy;

@Repository
public interface BuyRepository extends JpaRepository<Buy, Integer> {

}
