package com.foodbox.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.foodbox.exception.FooditemNotFoundException;
import com.foodbox.pojo.Fooditms;

public interface FooditemsService {

	public Fooditms addMovie(Fooditms movie) throws FooditemNotFoundException;

	public Fooditms removeMovie(int movieid) throws FooditemNotFoundException;
	
	public Fooditms updateMovie(Fooditms movie) throws FooditemNotFoundException;
	
	public Fooditms addMovieToShow(Fooditms movie, Integer showId) throws FooditemNotFoundException;

	public Fooditms viewMovie(int movieid) throws FooditemNotFoundException;

	public List<Fooditms> viewMovieList() throws FooditemNotFoundException;

	public List<Fooditms> viewMovieList(int theatreid);

	public List<Fooditms> viewMovieList(LocalDate date);
}
