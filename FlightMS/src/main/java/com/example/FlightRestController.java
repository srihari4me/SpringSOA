package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Flight;
import com.example.repository.FlightRepository;

@RestController
@RequestMapping("/flights")
public class FlightRestController {
	@Autowired
	private FlightRepository flightRepository;
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Flight> listOfFlights() {
		/*List<Flight> list = new ArrayList<Flight>();
		list.add(new Flight(100, new Date(), "Delhi"));
		list.add(new Flight(101, new Date(), "Dilli"));
		list.add(new Flight(102, new Date(), "New Delhi"));*/
		return flightRepository.findAll();
		//return list;
		//throw new RuntimeException("Unable to Service.....");
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Flight getFlight(@PathVariable("id") Integer id) {
		return flightRepository.findOne(id);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createFlight(@RequestBody Flight flight) {
		flightRepository.save(flight);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void udpateFlight(@PathVariable("id") Integer id, @RequestBody Flight flight) {
		
		Flight existingFlight = flightRepository.findOne(id);
		existingFlight.setDestinationName(flight.getDestinationName());
		existingFlight.setStartTime(flight.getStartTime());
		flightRepository.save(flight);
	}
}
