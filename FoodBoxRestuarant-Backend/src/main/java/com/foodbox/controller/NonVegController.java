package com.foodbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.exception.AccessForbiddenException;
import com.foodbox.exception.NonvegNotFoundException;
import com.foodbox.pojo.NonVeg;
import com.foodbox.service.ISeatService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/seats")
public class NonVegController {

	Logger logger = LoggerFactory.getLogger(NonVegController.class);
	@Autowired
	private ISeatService seatService;
	@Autowired
	LoginController loginController;

	@PostMapping("/addNonVeg")
	public ResponseEntity<NonVeg> addANonVeg(@RequestBody NonVeg nonveg)
			throws AccessForbiddenException, NonVegNotFoundException {
		
		nonveg = nonvegService.addSeat(seat);
		logger.info("-------NonVeg Added Successfully---------");
		return new ResponseEntity<>(nonveg, HttpStatus.CREATED);
	}

	@GetMapping("/findall")
	public ResponseEntity<List<NonVeg>> viewNonVegList() throws AccessForbiddenException, NonVegNotFoundException {
		
		logger.info("-------List of NonVeg Fetched Successfully---------");
		return ResponseEntity.ok(nonvegService.viewNonVegList());
	}

	
	@PutMapping("/update")
	public ResponseEntity<NonVeg> updateNonVeg(@RequestBody NonVeg nonveg)
			throws AccessForbiddenException, NonvegNotFoundException {
	
		ResponseEntity<NonVeg> response = null;
		if (nonveg == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			nonveg = nonvegService.updateNonVeg(nonveg);
			response = new ResponseEntity<>(nonveg, HttpStatus.OK);
			logger.info("-------NonVeg Updated Successfully---------");
		}
		return response;
	}

	@PutMapping("/buy")
	public ResponseEntity<NonVeg> BuyANonVeg(@RequestBody NonVeg nonveg)
			throws AccessForbiddenException, NonVegNotFoundException {
		
		nonveg = nonvegService.buyNonVeg(nonveg);
		logger.info("-------NonVeg buying Successfull---------");
		return new ResponseEntity<>(nonveg, HttpStatus.OK);
	}

	
	@PutMapping("/cancel")
	public ResponseEntity<NonVeg> CancelASeat(@RequestBody NonVeg nonveg)
			throws AccessForbiddenException, NonVegNotFoundException {
		
		nonveg = nonvegService.cancelNonVegBuying(nonveg);
		logger.info("-------NonVeg Cancellation Successfull---------");
		return new ResponseEntity<>(nonveg, HttpStatus.OK);
	}

}
