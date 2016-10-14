package com.example.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.model.Flight;

@FeignClient("flight-microservice")
public interface FeignFlightMicroServiceDAO {

	@RequestMapping(value = "/flights", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Flight> listOfFlights();

	@RequestMapping(value = "/flights/{id}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Flight getFlight(@PathVariable("id") Integer id);

	@RequestMapping(value = "/flights", method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createFlight(@RequestBody Flight flight);

	@RequestMapping(value = "/flights/{id}", method = RequestMethod.PUT)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void udpateFlight(@PathVariable("id") Integer id, @RequestBody Flight flight);
}
