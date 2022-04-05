package com.foodbox.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foodbox.exception.FooditemNotFoundException;
import com.foodbox.pojo.Fooditms;
import com.foodbox.service.FooditemsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/fooditems")
public class FooditemsController {

	Logger logger = LoggerFactory.getLogger(FooditemsController.class);
	@Autowired
	private foodService foodService;

	@PostMapping("/add")
	public ResponseEntity<fooditems> addMovie(@RequestBody food food)
			throws FooditemNotFoundException, IOException {
		movie = moviesService.addMovie(movie);
		logger.info("-------fooditems Added Successfully---------");
		return new ResponseEntity<>(movie, HttpStatus.CREATED);
	}

	

	@PutMapping("/update")
	public ResponseEntity<Fooditms> updateMovie(@RequestBody Fooditms movie)
			throws FooditemNotFoundException {

		ResponseEntity<Fooditms> response = null;
		if (movie == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			fooditems = fooditemsService.updatefoodtems(food);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------fooditems Updated Successfully---------");
		}
		return response;
	}
	
	@PutMapping("/map")
	public ResponseEntity<fooditems> addToShow(@RequestBody fooditems food,@RequestParam(required = false) Integer showId)
			throws FooditemNotFoundException {

		ResponseEntity<fooditems> response = null;
		if (food == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			food = foodService.addFoodToShow(food,showId);
			response = new ResponseEntity<>(food, HttpStatus.OK);
			logger.info("-------Movie Updated Successfully---------");
		}
		return response;
	}

	
	@GetMapping("/findall")
	public ResponseEntity<List<fooditmes>> viewfooditemsList() throws FoodNotFoundException {

		logger.info("-------Movie List Fetched---------");
		return ResponseEntity.ok(foodService.viewfooditemsList());
	}

		@GetMapping("/viewMovie/{movieId}")
	public ResponseEntity<Fooditms> viewMovie(@PathVariable int movieId)
			throws FooditemNotFoundException {

		ResponseEntity<Fooditms> response = null;
		try {
			Fooditms movie = moviesService.viewMovie(movieId);
			response = new ResponseEntity<>(movie, HttpStatus.OK);
			logger.info("-------fooditems With fooditem id " + foodId + " Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new foodNotFoundException("fooditems with " + foodId + " id dosen't exist");
		}
		return response;
		;
	}

	@DeleteMapping("/delete/{movieId}")
	public ResponseEntity<fooditems> removefooditems(@PathVariable int foodId)
			throws foodNotFoundException {

		ResponseEntity<Fooditms> response = null;
		Fooditems food = Service.viewFood(foodId);
		if (food == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			foodService.removeFooditems(foodId);
			response = new ResponseEntity<>(food, HttpStatus.OK);
			logger.info("-------fooditem With food id " + foodId + " Deleted---------");
		}
		return response;
	}

	
}
