package com.foodbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.exception.ScreenNotFoundException;
import com.foodbox.pojo.Screen;
import com.foodbox.pojo.Theatre;
import com.foodbox.service.ScreenService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/veg")
public class VegitemController {

	Logger logger = LoggerFactory.getLogger(ScreenController.class);

	@Autowired
	private VegService vegService;

	@PostMapping("/add")
	public ResponseEntity<Vegitem> addAVegitem(@RequestBody Veg veg,
			@RequestParam(required = false) )
			throws VegNotFoundException {

		logger.info("-------Vegitem Successfully added into cart " + vegitemId + "---------");
		return ResponseEntity.ok(VegService.addVegitem(veg, vegitemId));
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Vegitem> viewScreenList() throws  VegitemNotFoundException {

		logger.info("-------List Of veg items Fetched Successfully---------");
		return ResponseEntity.ok(vegService.viewCartList());
	}
	
	@GetMapping("/veg/{vegId}")
	public ResponseEntity<Veg>  getVegById(@PathVariable int vegId) throws VegNotFoundException {
		ResponseEntity<Veg> response = null;
		try {
		 Veg veg = vegitemService.getVeg(vegitemId);
			response = new ResponseEntity<>(veg, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<Vegitem> updateVegitem(@RequestBody Vegitem s, @RequestParam(required = false) )
			throws  VegNotFoundException {

		ResponseEntity<Vegitem> response = null;
		if (s == null) {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			s = vegitemService.updateScreen(s, VegId);
			response = new ResponseEntity<>(s, HttpStatus.OK);
			logger.info("-------vegitem Updated Successfully---------");
		}
		return response;
	}
}
