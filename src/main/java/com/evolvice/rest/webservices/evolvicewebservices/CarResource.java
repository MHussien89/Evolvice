package com.evolvice.rest.webservices.evolvicewebservices;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

import com.evolvice.rest.webservices.dataaccess.model.Car;
import com.evolvice.rest.webservices.dataaccess.repository.CarRepository;
import com.evolvice.rest.webservices.exceptions.CarNotFoundException;
import com.evolvice.rest.webservices.models.CarDto;

@RestController
public class CarResource {

	@Autowired
	CarRepository carRepository;

	@Autowired
	DozerBeanMapper dozerBeanMapper;

	static Mapper mapper = new DozerBeanMapper();

	@GetMapping("/cars")
	public List<CarDto> retrieveAllCars() {
		List<Car> savedCars = (List<Car>) carRepository.findAll();
		List<CarDto> carsDtos = new ArrayList<CarDto>();
		for (int i = 0; i < savedCars.size(); i++) {
			CarDto carDto = dozerBeanMapper.map(savedCars.get(i), CarDto.class);
			carsDtos.add(carDto);
		}
		return carsDtos;
	}

	@GetMapping("/cars/{id}")
	public CarDto retrieveCar(@PathVariable int id) {
		Optional<Car> savedCar = carRepository.findById(id);
		if (!savedCar.isPresent()) {

			throw new CarNotFoundException("id-" + id);
		}
		CarDto carDto = dozerBeanMapper.map(savedCar.get(), CarDto.class);

		return carDto;
	}

	@DeleteMapping("/cars/{id}")
	public void deleteCar(@PathVariable int id) {
		Optional<Car> savedCar = carRepository.findById(id);
		if (!savedCar.isPresent()) {
			throw new CarNotFoundException("id-" + id);
		}
		carRepository.deleteById(id);
	}

	@PostMapping("/cars")
	public ResponseEntity<Object> addCar(@Valid @RequestBody CarDto carDto) {
		Car car = dozerBeanMapper.map(carDto, Car.class);
		car = carRepository.save(car);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(car.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
