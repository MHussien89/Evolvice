package com.evolvice.rest.webservices.evolvicewebservices;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.evolvice.rest.webservices.dtos.CarDto;
import com.evolvice.rest.webservices.services.CarService;

@RestController
public class CarResource {

	@Autowired
	CarService carService;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	static Mapper mapper = new DozerBeanMapper();

	@GetMapping("/cars")
	public List<CarDto> retrieveAllCars() {
		return carService.getAllCars();
	}

	@GetMapping("/cars/{id}")
	public CarDto retrieveCar(@PathVariable int id) {
		return carService.getCar(id);
	}

	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable int id) {
		carService.deleteCar(id);
	}

	@PostMapping("/cars")
	public ResponseEntity<Object> addCar(@Valid @RequestBody CarDto carDto) {
		CarDto savedCar = carService.addCar(carDto);
		int carId = savedCar != null ? savedCar.getId() : 0;
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(carId).toUri();
		return ResponseEntity.created(location).build();
	}
}
