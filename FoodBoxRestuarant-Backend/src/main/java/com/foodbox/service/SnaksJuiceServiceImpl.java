package com.foodbox.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.pojo.Veg;
import com.foodbox.pojo.SnaksJuice;
import com.foodbox.pojo.Theatre;
import com.foodbox.repository.VegRepository;
import com.foodbox.repository.SnaksJuiceRepository;
import com.foodbox.repository.TheatreRepository;

@Service
public class SnaksJuiceServiceImpl implements SnaksJuiceService {
	@Autowired
	private SnaksJuiceRepository showrepository;
	@Autowired
	private TheatreRepository theatreRepository;
	@Autowired
	private VegRepository screenRepository;

	@Override
	public SnaksJuice addShow(SnaksJuice show, Integer theatreId, Integer screenId) {
		Theatre theatre = new Theatre();
		Veg screen = new Veg();
		if (theatreId != null) {
			theatre = theatreRepository.getOne(theatreId);
			show.setTheatre(theatre);
		}
		if (screenId != null) {
			screen = screenRepository.getOne(screenId);
			show.setScreen(screen);
		}
		showrepository.saveAndFlush(show);
		return show;
	}

	@Override
	public SnaksJuice updateShow(SnaksJuice show, Integer theatreId, Integer screenId) {
		Theatre theatre = new Theatre();
		Veg screen = new Veg();
		if (theatreId != null) {
			theatre = theatreRepository.getOne(theatreId);
			show.setTheatre(theatre);
		}
		if (screenId != null) {
			screen = screenRepository.getOne(screenId);
			show.setScreen(screen);
		}
		showrepository.saveAndFlush(show);
		return show;
	}

	@Override
	public SnaksJuice removeShow(int showid) {
		SnaksJuice s = showrepository.findById(showid).get();
		showrepository.delete(s);
		return s;
	}

	@Override
	public SnaksJuice viewShow(int showid) {
		return showrepository.findById(showid).get();
	}

	@Override
	public List<SnaksJuice> viewAllShows() {
		return showrepository.findAll();
	}

	@Override
	public List<SnaksJuice> viewShowList(int theatreid) {
		return showrepository.getAllByTheatreId(theatreid);
		// return null;
	}

	@Override
	public List<SnaksJuice> viewShowList(LocalDate date) {
		List<SnaksJuice> shList = new ArrayList<>();
		for (SnaksJuice show : showrepository.findAll()) {
			if (show.getShowDate() != null && show.getShowDate().isEqual(date)) {
				shList.add(show);
			}
		}
		return shList;
	}

}
