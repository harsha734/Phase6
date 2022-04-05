package com.foodbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbox.exception.PuyNotFoundException;
import com.foodbox.pojo.Buy;
import com.foodbox.pojo.NonVeg;
import com.foodbox.pojo.Puy;
import com.foodbox.repository.BuyRepository;
import com.foodbox.repository.NonVegRepository;
import com.foodbox.repository.PuyRepository;

@Service
public class PuyServiceImpl implements PuyService {

	private PuyRepository ticketRepository;

	public PuyServiceImpl(PuyRepository ticketRepository) {
		this.ticketRepository = ticketRepository;
	}
	
	@Autowired
	private NonVegRepository seatRepository;
	
	@Autowired
	private BuyRepository bookingRepository;
	
	@Override
	public Puy addTicket(Puy ticket,Integer transactionId) throws PuyNotFoundException {
		Buy booking=new Buy();
		if(transactionId!=null) {
			booking=bookingRepository.findById(transactionId).get();
			booking.setTransactionStatus("Completed");
			ticket.setBooking(booking);
		}
		ticketRepository.saveAndFlush(ticket);
		/*
		 * for(Seat s:ticket.getSeats()) { s.setTickett(ticket);
		 * seatRepository.saveAndFlush(s); }
		 */
		return ticket;
	}

	@Override
	public List<Puy> viewTicketList() throws PuyNotFoundException {
		List<Puy> ti = ticketRepository.findAll();
		if (ti.size() == 0)
			throw new PuyNotFoundException("No tickets are avaliable");
		return ti;
	}

	@Override
	public Puy findTicket(int ticketId) {
		// TODO Auto-generated method stub
		return ticketRepository.findById(ticketId).get();
	}

}
