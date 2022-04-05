package com.foodbox.service;

import java.util.List;

import com.foodbox.exception.VegNotFoundException;
import com.foodbox.pojo.Veg;
import com.foodbox.pojo.Theatre;

public interface VegService {
	public Veg addScreen(Veg screen, Integer theatreId) throws VegNotFoundException;
	public List<Veg> viewScreenList() throws VegNotFoundException;
	public Veg updateScreen(Veg s, Integer theatreId);
	public Veg viewScreen(int screenId) throws VegNotFoundException;
	public Theatre getTheatre(int screenId) throws VegNotFoundException;
}
