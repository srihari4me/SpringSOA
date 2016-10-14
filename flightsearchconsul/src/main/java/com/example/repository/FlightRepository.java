package com.example.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Flight;



public interface FlightRepository extends MongoRepository<Flight, Long> {
	List<Flight> findByOriginAndDestinationAndFlightDate(String origin,String destination, String flightDate);

	Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
} 