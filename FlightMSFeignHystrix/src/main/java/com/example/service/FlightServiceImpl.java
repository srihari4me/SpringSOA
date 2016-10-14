package com.example.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.FeignFlightMicroServiceDAO;
import com.example.model.Flight;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	private FeignFlightMicroServiceDAO dao;

	@Override
	@HystrixCommand(fallbackMethod="listOfFlightsFallback")
	public Iterable<Flight> listOfFlights() {
		// TODO Auto-generated method stub
		return dao.listOfFlights();
	}
	
	public Iterable<Flight> listOfFlightsFallback() {
		// TODO Auto-generated method stub
		List<Flight> list = new ArrayList<Flight>();
		list.add(new Flight(20, new Date(), "Fallback Flight1"));
		list.add(new Flight(30, new Date(), "Fallback Flight2"));
		return list;
	}
}
