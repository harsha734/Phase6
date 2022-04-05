package com.foodbox.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodbox.pojo.Fooditms;

@Repository
public interface Fooditems extends JpaRepository<Fooditms, Integer> {
	// @Query("select m from Movie m join m.show s where s.theatre.theatreId = :id")
	// List<Movie> getAllByTheatreId(@Param("id") int id);

	List<Fooditms> getAllBymovieDate(LocalDate date);

}
