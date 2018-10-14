package com.evolvice.rest.webservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	
}
