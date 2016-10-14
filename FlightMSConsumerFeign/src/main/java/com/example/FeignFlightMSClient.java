package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Flight;

@RestController
public class FeignFlightMSClient {

	@Autowired
	FeignFlightMicroServiceConsumer discoveryClient;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Flight> listOfFlights() {
		return discoveryClient.listOfFlights();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void udpateFlight(@PathVariable("id") Integer id, @RequestBody Flight flight) {
		discoveryClient.udpateFlight(id, flight);
	}
}
