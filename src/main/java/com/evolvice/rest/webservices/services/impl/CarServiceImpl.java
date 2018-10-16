package com.evolvice.rest.webservices.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evolvice.rest.webservices.dataaccess.model.Car;
import com.evolvice.rest.webservices.dataaccess.repository.CarRepository;
import com.evolvice.rest.webservices.dtos.CarDto;
import com.evolvice.rest.webservices.exceptions.CarNotFoundException;
import com.evolvice.rest.webservices.services.CarService;

@Service("carService")
public class CarServiceImpl implements CarService {

	@Autowired
	CarRepository carRepository;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	@Override
	public List<CarDto> getAllCars() {
		List<Car> savedCars = carRepository.findAll();
		List<CarDto> carsDtos = new ArrayList<CarDto>();
		for (int i = 0; i < savedCars.size(); i++) {
			CarDto carDto = dozerBeanMapper.map(savedCars.get(i), CarDto.class);
			carsDtos.add(carDto);
		}
		return carsDtos;
	}

	@Override
	public CarDto getCar(int id) {
		Optional<Car> savedCar = carRepository.findById(id);
		if (!savedCar.isPresent()) {
			throw new CarNotFoundException("id-" + id);
		}
		CarDto carDto = dozerBeanMapper.map(savedCar.get(), CarDto.class);
		return carDto;
	}

	@Override
	public CarDto addCar(CarDto carDto) {
		Car car = dozerBeanMapper.map(carDto, Car.class);
		car = carRepository.save(car);
		CarDto savedCar = dozerBeanMapper.map(car, CarDto.class);
		return savedCar;
	}

	@Override
	public void deleteCar(int id) {
		Optional<Car> savedCar = carRepository.findById(id);
		if (!savedCar.isPresent()) {
			throw new CarNotFoundException("id-" + id);
		}
		carRepository.deleteById(id);
	}

}
