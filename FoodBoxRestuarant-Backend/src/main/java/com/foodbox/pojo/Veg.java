package com.foodbox.pojo;

import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Veg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int screenId;
	@JsonIgnore
	@ManyToOne
	
	@OneToMany(mappedBy = "veg",cascade = CascadeType.ALL)
	private List<SnaksJuice> show;
	private String vegName;
	@Column(name = "rowss")
	private int rows;
	@Column(name = "columnss")
	private int columns;

	public Veg() {

	}

	public Veg( List<Veg> show, String vegName, int rows, int columns) {
		super();
		
		
		this.vegName = vegName;
		this.rows = rows;
		this.columns = columns;
	}

	public int getScreenId() {
		return screenId;
	}

	public void setScreenId(int screenId) {
		this.screenId = screenId;
	}

	public String getVegName() {
		return vegName;
	}

	public void setVegName(String vegName) {
		this.vegName = vegName;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	
	
}
