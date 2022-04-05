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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodbox.exception.AccessForbiddenException;
import com.foodbox.exception.PuyNotFoundException;
import com.foodbox.pojo.Puy;
import com.foodbox.service.PuyService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/puy")
public class PuyController {

	Logger logger = LoggerFactory.getLogger(PuyController.class);

	@Autowired
	private PuyService puyService;
	@Autowired
	LoginController loginController;

	@PostMapping("/puy")
	public ResponseEntity<Puy> addATicket(@RequestBody Puy puy,@RequestParam(required = false) Integer buyId)
			throws AccessForbiddenException, PuyNotFoundException {
		
		Puy = puyService.addPuy(puy,buyId);
		
		logger.info("-------Puy Created Successfully---------");
		return new ResponseEntity<>(puy, HttpStatus.CREATED);
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Puy>> viewPuyList() throws AccessForbiddenException, PuyNotFoundException {
		
		return ResponseEntity.ok(puyService.viewPuyList());
	}

	@GetMapping("/{PuyId}")
	public Puy findATicket(@PathVariable int puyId) throws PuyNotFoundException, AccessForbiddenException {	
		Puy t = null;
		try {
			t = puyService.findTicket(puyId);
			logger.info("-------Puy with puyId " + puyId + " Foound Successfully---------");
		} catch (Exception e) {
			throw new PuyNotFoundException("Invalid Puyment ID");
		}
		return t;

	}

}
