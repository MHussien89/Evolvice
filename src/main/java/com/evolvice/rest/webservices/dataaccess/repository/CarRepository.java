package com.evolvice.rest.webservices.dataaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.evolvice.rest.webservices.dataaccess.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Integer> {

	
	public List<Car> findAll();
	
//	public Car findByModel(String model);
}
