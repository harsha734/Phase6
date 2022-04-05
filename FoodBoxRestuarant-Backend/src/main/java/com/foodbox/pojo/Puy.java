package com.foodbox.pojo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Puy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private int noOfSeats;
	private boolean ticketStatus;
	//@OneToMany(mappedBy = "ticket")
	@OneToMany
	private List<NonVeg> seats;
	@OneToOne
	private Buy booking;

	public Puy() {

	}

	public Puy(int noOfSeats, boolean ticketStatus, List<NonVeg> seats, Buy booking) {
		super();
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.seats = seats;
		this.booking = booking;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<NonVeg> getSeats() {
		return seats;
	}

	public void setSeats(List<NonVeg> seats) {
		this.seats = seats;
	}

	public Buy getBooking() {
		return booking;
	}

	public void setBooking(Buy booking) {
		this.booking = booking;
	}

}