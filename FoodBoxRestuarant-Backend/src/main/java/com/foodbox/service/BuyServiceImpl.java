package com.foodbox.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mts.repoImpl.QueryClass;
import com.foodbox.exception.BuyNotFoundException;
import com.foodbox.pojo.Buy;
import com.foodbox.pojo.Customer;
import com.foodbox.pojo.NonVeg;
import com.foodbox.pojo.SnaksJuice;
import com.foodbox.pojo.Puy;
import com.foodbox.repository.BuyRepository;
import com.foodbox.repository.CustomerRepository;
import com.foodbox.repository.Fooditems;
import com.foodbox.repository.SnaksJuiceRepository;
import com.foodbox.repository.PuyRepository;

@Service
public class BuyServiceImpl implements IBuyService {

	@Autowired
	private BuyRepository buyRepository;
	@Autowired
	Fooditems fooditemRepository;
	@Autowired
	SnaksJuiceRepository showRepository;
	@Autowired
	CustomerRepository custoRepository;
	@Autowired
	PuyRepository ticketRepository;
	@Autowired
	QueryClass query;

	@Override
	public Buy addBooking(Buy booking, Integer customerId, Integer showId) throws BuyNotFoundException {
		Customer customer = new Customer();
		SnaksJuice show=new SnaksJuice();
		
		if(showId!=null) {
				//customer = custoRepository.getOne(customerId);
				show=showRepository.findById(showId).get();
				show.setBooking(booking);
				//booking.setCustomer(customer);
				booking.setShow(show);
		}
			bookingRepository.saveAndFlush(booking);
			showRepository.saveAndFlush(show);
		return bookingRepository.findById(booking.getTransactionId()).get();
	}

	@Override
	public Buy updateBooking(Buy booking) throws BuyNotFoundException {
		bookingRepository.saveAndFlush(booking);
		return bookingRepository.getOne(booking.getTransactionId());
	}

	@Override
	public Buy cancelBooking(int bookingid) throws BuyNotFoundException {
		Buy b = bookingRepository.getOne(bookingid);
		bookingRepository.delete(b);
		return b;
	}

	@Override
	public List<Buy> showAllBookings(int movieid) throws BuyNotFoundException {
		List<Buy> bk = query.getAllByMovieId(movieid);
		/*
		 * if (bk.size() == 0) throw new BookingNotFoundException("No bookings found");
		 */
		return bk;
	}

	@Override
	public List<Buy> showAllBookings(LocalDate bookingdate) throws BuyNotFoundException {
		List<Buy> bkList = new ArrayList<>();
		for (Buy booking : bookingRepository.findAll()) {
			if (booking.getBookingDate() != null && booking.getBookingDate().isEqual(bookingdate)) {
				bkList.add(booking);
			}
		}
		if (bkList.size() == 0)
			throw new BuyNotFoundException("No bookings found");
		else {
			return bkList;
		}
	}

	@Override
	public double calculateTotalCost(int bookingid) {
		List<Puy> tickets = ticketRepository.findAll();
		Set<NonVeg> Seats = new HashSet<>();
		for (Puy ticket : tickets) {
			if (bookingid == ticket.getBooking().getTransactionId()) {
				Seats.addAll(ticket.getSeats());
			}
		}
		double amount = 0;
		for (NonVeg seat : Seats) {
			amount = amount + seat.getPrice();
		}
		Buy booking = bookingRepository.getOne(bookingid);
		booking.setTotalCost(amount);
		bookingRepository.saveAndFlush(booking);
		return amount;
	}

	@Override
	public List<Buy> viewBookingList() throws BuyNotFoundException {
		List<Buy> bk = bookingRepository.findAll();
		/*
		 * if (bk.size() == 0) throw new BookingNotFoundException("No bookings found");
		 */
		return bk;
	}

	@Override
	public Buy viewBooking(int bookingid) throws BuyNotFoundException {
		return bookingRepository.findById(bookingid).get();
	}

}
