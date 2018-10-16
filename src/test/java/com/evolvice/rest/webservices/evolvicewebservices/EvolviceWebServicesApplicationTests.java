package com.evolvice.rest.webservices.evolvicewebservices;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.evolvice.rest.webservices.dataaccess.model.Car;
import com.evolvice.rest.webservices.dataaccess.repository.CarRepository;
import com.evolvice.rest.webservices.dtos.CarDto;
import com.evolvice.rest.webservices.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EvolviceWebServicesApplicationTests {

	MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;

	@MockBean
	CarService carService;

	@Test
	public void contextLoads() {
	}

	/**
	 * List of samples mangas
	 */
	private List<CarDto> cars;

	@Before
	public void setup() throws Exception {

		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

		CarDto carDto = new CarDto(1, "Kia", "RIO", new Date(), "Blue", 233000);
		carDto.setId(1);
		CarDto carDto1 = new CarDto(2, "Hynday", "Accent", new Date(), "Red", 240000);
		carDto1.setId(2);
		CarDto carDto2 = new CarDto(3, "Ford", "Focus", new Date(), "Black", 440000);
		carDto2.setId(3);
		cars = new ArrayList<>();
		cars.add(carDto);
		cars.add(carDto1);
		cars.add(carDto2);

	}

	@Test
	public void testGetCarById() throws Exception {
		when(carService.getCar(2)).thenReturn(new CarDto(1, "Mazda", "S3", new Date(), "red", 500000));

		mockMvc.perform(get("/cars/2").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.brand", is("Mazda")));
	}

	@Test
	public void testGetAllCars() throws Exception {
		when(carService.getAllCars()).thenReturn(cars);

		mockMvc.perform(get("/cars").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.*", Matchers.hasSize(3)));
	}

	@Test
	public void testPostCar() throws Exception {
		when(carService.addCar(Mockito.any(CarDto.class))).thenReturn(Mockito.any(CarDto.class));

		mockMvc.perform(post("/cars").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(new CarDto(1, "BMW", "4GENs", new Date(), "black", 770000))))
				.andExpect(status().isCreated());
	}

	/*
	 * converts a Java object into JSON representation
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
