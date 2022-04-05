package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.exception.NonvegNotFoundException;
import com.foodbox.pojo.NonVeg;
import com.foodbox.pojo.SeatStatus;
import com.foodbox.repository.NonVegRepository;

@Service
public class NonVegServiceImpl implements ISeatService {
	@Autowired
	private NonVegRepository seatRepository;

	@Override
	public NonVeg addSeat(NonVeg seat) throws NonvegNotFoundException {
		if (seat != null) {
			if (seatRepository.existsById(seat.getSeatId())) {
				throw new NonvegNotFoundException("Seat with this id already exists");
			} else {
				seatRepository.saveAndFlush(seat);
			}
		}
		return seatRepository.getOne(seat.getSeatId());
	}

	@Override
	public List<NonVeg> viewSeatList() throws NonvegNotFoundException {
		List<NonVeg> li = seatRepository.findAll();
		/*
		 * if (li.size() == 0) throw new SeatNotFoundException("No seats found");
		 */
		return li;
	}

	@Override
	public NonVeg updateSeat(NonVeg seat) {
		// TODO Auto-generated method stub
		return seatRepository.saveAndFlush(seat);
	}

	@Override
	public NonVeg bookSeat(NonVeg seat) {
		seat.setStatus(SeatStatus.BOOKED);
		return seatRepository.saveAndFlush(seat);
	}

	@Override
	public NonVeg cancelSeatBooking(NonVeg seat) {
		seat.setStatus(SeatStatus.CANCELLED);
		return seatRepository.saveAndFlush(seat);
	}

	@Override
	public NonVeg blockSeat(NonVeg seat) {
		seat.setStatus(SeatStatus.BLOCKED);
		return seatRepository.saveAndFlush(seat);
	}

}
