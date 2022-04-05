package com.foodbox.service;

import java.time.LocalDate;
import java.util.List;

import com.foodbox.pojo.SnaksJuice;

public interface SnaksJuiceService {

	public SnaksJuice addShow(SnaksJuice show, Integer theatreId, Integer screenId);

	public SnaksJuice updateShow(SnaksJuice show, Integer theatreId, Integer screenId);

	public SnaksJuice removeShow(int showid);

	public SnaksJuice viewShow(int showid);

	public List<SnaksJuice> viewAllShows();

	public List<SnaksJuice> viewShowList(int theatreid);

	public List<SnaksJuice> viewShowList(LocalDate date);

}
