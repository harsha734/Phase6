package com.foodbox.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.foodbox.exception.AccessForbiddenException;
import com.foodbox.exception.BuyNotFoundException;
import com.foodbox.exception.VegNotFoundException;
import com.foodbox.pojo.Buy;
import com.foodbox.pojo.Veg;
import com.foodbox.service.IBuyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/buy")
public class BuyController {

	Logger logger = LoggerFactory.getLogger(BuyController.class);

	@Autowired
	private IBuyService bookingService;
	@Autowired
	LoginController loginController;

	
	@PostMapping(value = "/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Buy> additembuy(@RequestBody Buy t,
			@RequestParam(required = false) Integer customerId,@RequestParam(required = false) Integer showId)
			throws AccessForbiddenException, BuyNotFoundException {
		
		return ResponseEntity.ok(buyService.addBuy(t, customerId,showId));
	}

	
	@GetMapping("/findall")
	public ResponseEntity<List<Buy>> viewAllBookings() throws AccessForbiddenException, BuyNotFoundException {
		
		logger.info("-------List Of fooditems Fetched Successfully---------");
		return ResponseEntity.ok(bookingService.viewBookingList());
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Buy updateTicketBooking(@RequestBody Buy t)
			throws BuyNotFoundException, AccessForbiddenException {
		
		logger.info("-------fooditems Updated Successfully---------");
		return buyService.updateBuy(t);
	}

	
	@DeleteMapping("buy/{buyId}")
	public Buy deleteTicketBookingById(@PathVariable int bookingId)
			throws BuyNotFoundException, AccessForbiddenException {
		
		logger.info("-------Buying With fooditems Id " + buyId + " Deleted Successfully---------");
		return buyService.cancelBooking(buyId);
	}
	
	@GetMapping("/buy/{buyId}")
	public ResponseEntity<Buy> viewBooking(@PathVariable int bookingId)
			throws BuyNotFoundException {
		ResponseEntity<Buy> response = null;
		try {
			Buy buy = buyService.viewBuy(buyId);
			response = new ResponseEntity<>(booking, HttpStatus.OK);
			logger.info("------fooditem Found---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new BuyNotFoundException("fooditem dosen't exist");
		}
		return response;
	}
	
	@GetMapping("/byveg/{vegId}")
	public ResponseEntity<List<Buy>> viewvegByvegId(@PathVariable int vegId)
			throws AccessForbiddenException, BuyNotFoundException {
		
		logger.info("-------orderss With vegId " +vegId + " Fetched Successfully---------");
		return ResponseEntity.ok(bookingService.showAllBookings(movieId));
	}

	@GetMapping("/byDate/{date}")
	public ResponseEntity<List<Buy>> viewvegByLocalDate(
			@RequestParam("buyDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
			throws AccessForbiddenException, BuyNotFoundException {
		
		logger.info("-------Buy With Date " + date + " Fetched Successfully---------");
		return ResponseEntity.ok(buyService.showAllBuys(date));
	}

	@GetMapping("/puy/{buyId}")
	public double TotalBookingost(@PathVariable int bookingId)
			throws AccessForbiddenException, BuyNotFoundException {
		
		logger.info("-------Total Cost Of orders displayed Successfully---------");
		return buyService.calculateTotalCost(buyId);
	}
}
