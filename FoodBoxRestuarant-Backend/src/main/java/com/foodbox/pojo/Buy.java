package com.foodbox.pojo;

import java.time.LocalDate;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Buy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	@OneToOne(mappedBy = "booking")
	private SnaksJuice show;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	private String transactionMode;
	private String transactionStatus;
	private double totalCost;
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	@JsonIgnore
	@OneToOne(mappedBy = "booking")
	private Puy ticket;

	public Buy() {

	}

	public Buy(SnaksJuice show, LocalDate bookingDate, String transactionMode, String transactionStatus, double totalCost,
			Customer customer, Puy ticket) {
		super();
		this.show = show;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.customer = customer;
		this.ticket = ticket;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public SnaksJuice getShow() {
		return show;
	}

	public void setShow(SnaksJuice show) {
		this.show = show;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getTransactionMode() {
		return transactionMode;
	}

	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Puy getTicket() {
		return ticket;
	}

	public void setTicket(Puy ticket) {
		this.ticket = ticket;
	}


}