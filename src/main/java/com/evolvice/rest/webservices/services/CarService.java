package com.evolvice.rest.webservices.services;

import java.util.List;

import com.evolvice.rest.webservices.dtos.CarDto;

public interface CarService {

	public List<CarDto> getAllCars();

	public CarDto getCar(int id);

	public CarDto addCar(CarDto carDto);

	public void deleteCar(int id);
}
