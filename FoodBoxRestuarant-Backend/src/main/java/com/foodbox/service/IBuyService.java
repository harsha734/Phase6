package com.foodbox.service;

import java.time.LocalDate;
import java.util.List;

import com.foodbox.exception.BuyNotFoundException;
import com.foodbox.exception.VegNotFoundException;
import com.foodbox.pojo.Buy;
import com.foodbox.pojo.Veg;

public interface IBuyService {
	public Buy addBooking(Buy booking, Integer customerId,Integer showId) throws BuyNotFoundException;

	public List<Buy> viewBookingList() throws BuyNotFoundException;

	public Buy updateBooking(Buy booking) throws BuyNotFoundException;

	public Buy cancelBooking(int bookingid) throws BuyNotFoundException;

	public List<Buy> showAllBookings(int movieid) throws BuyNotFoundException;
	public Buy viewBooking(int bookingid) throws BuyNotFoundException;
	public List<Buy> showAllBookings(LocalDate bookingdate) throws BuyNotFoundException;

	public double calculateTotalCost(int bookingid);

}
