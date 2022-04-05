package com.foodbox.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodbox.pojo.SnaksJuice;

public interface SnaksJuiceRepository extends JpaRepository<SnaksJuice, Integer> {
	@Query("select s from Show s where s.theatre.theatreId = :id")
	List<SnaksJuice> getAllByTheatreId(@Param("id") int id);
}
