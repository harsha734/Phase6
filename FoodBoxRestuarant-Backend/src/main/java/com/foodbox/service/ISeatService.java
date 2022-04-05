package com.foodbox.service;

import java.util.List;

import com.foodbox.exception.NonvegNotFoundException;
import com.foodbox.pojo.NonVeg;

public interface ISeatService {

	public NonVeg addSeat(NonVeg seat) throws NonvegNotFoundException;

	public List<NonVeg> viewSeatList() throws NonvegNotFoundException;

	public NonVeg updateSeat(NonVeg seat);

	public NonVeg bookSeat(NonVeg seat);

	public NonVeg cancelSeatBooking(NonVeg seat);

	public NonVeg blockSeat(NonVeg seat); // not available for any booking
}
