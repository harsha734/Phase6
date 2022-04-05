package com.foodbox.pojo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NonVeg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nonvegId;
	private String nonvegName;
	private String type;
	private double price;
	

	@Enumerated(EnumType.STRING)
	private SeatStatus status;
	@JsonIgnore
	@ManyToOne
	private Puy puy;
	public NonVeg() {
	}
	public NonVeg(String nonvegName, String type, double price,  Puy puy) {
		super();
		this.nonvegName = nonvegName;
		this.type = type;
		this.price = price;
		
		this.puy = puy;
	}
	public int getNonvegId() {
		return nonvegId;
	}
	public void setNonvegId(int nonvegId) {
		this.nonvegId = nonvegId;
	}
	public String getNonvegName() {
		return nonvegName;
	}
	public void setNonvegName(String nonvegName) {
		this.nonvegName = nonvegName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Puy getPuy() {
		return puy;
	}
	public void setPuy(Puy puy) {
		this.puy = puy;
	}
	
}
