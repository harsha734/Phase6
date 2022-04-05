package com.foodbox.pojo;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.*;

@Entity
@Table(name = "snakjuice")
@DynamicUpdate
public class SnaksJuice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int snakjuiceId;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	
	private int  snakjuicid;
	
	
	private String snakjuiceName;
	@OneToOne(mappedBy = "snakjuice")
	private Fooditms fooditem;
	@JsonIgnore
	@ManyToOne
	private Veg veg;
	
	@JsonIgnore
	@OneToOne
	private Buy buy;

	
	
	private LocalDate showDate;

	public SnaksJuice() {

	}

	public int getSnakjuiceId() {
		return snakjuiceId;
	}

	public void setSnakjuiceId(int snakjuiceId) {
		this.snakjuiceId = snakjuiceId;
	}

	public int getSnakjuicid() {
		return snakjuicid;
	}

	public void setSnakjuicid(int snakjuicid) {
		this.snakjuicid = snakjuicid;
	}

	public String getSnakjuiceName() {
		return snakjuiceName;
	}

	public void setSnakjuiceName(String snakjuiceName) {
		this.snakjuiceName = snakjuiceName;
	}

	public Fooditms getFooditem() {
		return fooditem;
	}

	public void setFooditem(Fooditms fooditem) {
		this.fooditem = fooditem;
	}

	public Veg getVeg() {
		return veg;
	}

	public void setVeg(Veg veg) {
		this.veg = veg;
	}

	public Buy getBuy() {
		return buy;
	}

	public void setBuy(Buy buy) {
		this.buy = buy;
	}

	


}
