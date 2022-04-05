package com.foodbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.foodbox.exception.ShowNotFoundException;
import com.foodbox.pojo.Show;
import com.foodbox.service.ShowService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/snaksjuice")
public class SnaksJuiceController {

	Logger logger = LoggerFactory.getLogger(SnaksJuiceController.class);
	@Autowired
	private SnakJuiceService snakjuiceService;

	@PostMapping("/addSnakJuic")
	public ResponseEntity<SnakJuic> addSnakJuic(@RequestBody SnakJuic snakjuic, @RequestParam(required = false) ,
			@RequestParam(required = false) Integer SnakJuicId)  {

		SnakJuicService.addSnakJuic(snakjuic,  SnakJuicId);
		logger.info("-------SnakJuic Added Succesfully--------");
		return new ResponseEntity<>(SnakJuic, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{SnakJuicId}")
	public ResponseEntity<SnakJuic> removeSnakJuic(@PathVariable int showId)  {

		ResponseEntity<SnakJuic> response = null;
		SnakJuic snakjuic = SnakJuicService.viewSnakJuic(SnakJuicId);
		if (snakjuic == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			snakjuicService.removeSnakJuic(snakjuicId);
			response = new ResponseEntity<>(snakjuic, HttpStatus.OK);
			logger.info("-------SnakJuic with SnakJuicId " + snakjuicId + " Deleted Successfully---------");
		}
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<Show> updateShow(@RequestBody Show show, @RequestParam(required = false) Integer theatreId,
			@RequestParam(required = false) Integer screenId)  {

		ResponseEntity<Show> response = null;
		if (show == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			showService.updateShow(show, theatreId, screenId);
			response = new ResponseEntity<>(show, HttpStatus.OK);
			logger.info("-------Show Updated Successfully---------");
		}
		return response;
	}

	
	@GetMapping("/view/{SnakJuicId}")
	public ResponseEntity<SnakJuic> viewShow(@PathVariable int SnakJuicId)
			throws  SnakJuicNotFoundException {

		ResponseEntity<SnakJuic> response = null;
		try {
			SnakJuic snakjuic = SnakJuicService.viewSnakJuic(snakjuicId);
			response = new ResponseEntity<>(snakjuic, HttpStatus.OK);
			logger.info("-------SnakJuic with SnakJuicId " + snakjuicId + " Found Successfully---------");
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			throw new SnakJuicNotFoundException("SnakJuic with " + snakjuicId + " id dosen't exist");
		}
		return response;
	}

	
}
