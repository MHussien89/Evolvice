package com.evolvice.rest.webservices.models;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Details about car model")
public class CarDto {
	
	private Integer id;
	
	@Size(min=3, message="Brand should have at least 2 characters")
	@ApiModelProperty(notes="Name should be at least 2 characters")
	private String brand;
	private String model;
	
	@Past
	@ApiModelProperty(notes="yearOfProduction should be in the past")
	private Date yearOfProduction;
	private String color;
	private double price;
	
	
	
	public CarDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDto(Integer id, String brand, String model, Date yearOfProduction, String color, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.yearOfProduction = yearOfProduction;
		this.color = color;
		this.price = price;
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Date getYearOfProduction() {
		return yearOfProduction;
	}
	public void setYearOfProduction(Date yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
