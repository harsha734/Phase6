package com.foodbox.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.exception.VegNotFoundException;
import com.foodbox.pojo.Veg;
import com.foodbox.pojo.Theatre;
import com.foodbox.repository.VegRepository;
import com.foodbox.repository.TheatreRepository;

/**
 * 
 * @author Thejesh
 * @category Screen Service Implementation
 */
@Service
public class VegServiceImpl implements VegService {

	@Autowired
	private VegRepository screenRepository;
	@Autowired
	private TheatreRepository theatreRepository;

	/**
	 * @return screenList
	 */
	@Override
	public List<Veg> viewScreenList() throws VegNotFoundException {
		List<Veg> screen = screenRepository.findAll();
		if (screen.size() == 0)
			throw new VegNotFoundException("No screens found");
		return screen;
	}

	/**
	 * @return screen
	 */
	@Override
	public Veg addScreen(Veg screen, Integer theatreId) throws VegNotFoundException {
		Theatre theatre = new Theatre();
		if (theatreId != null) {
			if (screenRepository.existsById(screen.getScreenId())) {
				throw new VegNotFoundException("Screen already exists");
			} else {
				theatre = theatreRepository.getOne(theatreId);
				screen.setTheatre(theatre);
			}
			screenRepository.saveAndFlush(screen);
		}
		return screen;
	}
	@Override
	public Veg viewScreen(int screenId) throws VegNotFoundException {
		return screenRepository.findById(screenId).get();
		}
	/**
	 * @return updatedScreen
	 */
	@Override
	public Veg updateScreen(Veg screen, Integer theatreId) {
		Theatre theatre = new Theatre();
		if (theatreId != null) {
			theatre = theatreRepository.getOne(theatreId);
			screen.setTheatre(theatre);
		}
		screenRepository.saveAndFlush(screen);
		return screen;
	}

	@Override
	public Theatre getTheatre(int screenId) throws VegNotFoundException {
		Veg screen =screenRepository.findById(screenId).get();
		Theatre theatre=screen.getTheatre();
		return theatre;
	}

}
