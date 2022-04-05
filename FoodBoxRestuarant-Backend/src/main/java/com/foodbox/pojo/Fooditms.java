package com.foodbox.pojo;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * 
 * @author surya
 *
 */
@Entity
@Table(name = "movie")
@DynamicUpdate
public class Fooditms {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int fooditemId;
	private String fooditemName;
	private String fooditemOption;
	private String fooditemPrice;
	private String fooditemCatogiry;
	private String fooditemDescription;
	private String fooditemRating;
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate movieDate;
	@JsonIgnore
	@OneToOne
	private SnaksJuice show;

	public Fooditms() {

	}

	public Fooditms(String movieName, String movieGenre, String movieHours, String movieLanguage, String movieDescription,
			String movieRating, LocalDate movieDate, SnaksJuice show) {
		super();
		this.fooditemName = fooditemName;
		this.fooditemOption = fooditemOption;
		this.fooditemPrice = fooditemPrice;
		this.fooditemCatogiry = fooditemCatogiry;
		this.fooditemDescription = fooditemDescription;
		this.fooditemRating = fooditemRating;
		
		this.show = show;
	}

	public int getFooditemId() {
		return fooditemId;
	}

	public void setFooditemId(int fooditemId) {
		this.fooditemId = fooditemId;
	}

	public String getFooditemName() {
		return fooditemName;
	}

	public void setFooditemName(String fooditemName) {
		this.fooditemName = fooditemName;
	}

	public String getFooditemOption() {
		return fooditemOption;
	}

	public void setFooditemOption(String fooditemOption) {
		this.fooditemOption = fooditemOption;
	}

	public String getFooditemPrice() {
		return fooditemPrice;
	}

	public void setFooditemPrice(String fooditemPrice) {
		this.fooditemPrice = fooditemPrice;
	}

	public String getFooditemCatogiry() {
		return fooditemCatogiry;
	}

	public void setFooditemCatogiry(String fooditemCatogiry) {
		this.fooditemCatogiry = fooditemCatogiry;
	}

	public String getFooditemDescription() {
		return fooditemDescription;
	}

	public void setFooditemDescription(String fooditemDescription) {
		this.fooditemDescription = fooditemDescription;
	}

	public String getFooditemRating() {
		return fooditemRating;
	}

	public void setFooditemRating(String fooditemRating) {
		this.fooditemRating = fooditemRating;
	}


}
