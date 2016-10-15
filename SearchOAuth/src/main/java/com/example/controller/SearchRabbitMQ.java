package com.example.controller;
 

public class SearchRabbitMQ {
	String flightNumber;
	Integer newInventory;
	
	String flightDate;
	
	
	public SearchRabbitMQ() {
		super();
	}

	public SearchRabbitMQ(String flightNumber, Integer newInventory, String flightDate) {
		super();
		this.flightNumber = flightNumber;
		this.newInventory = newInventory;
		this.flightDate = flightDate;
	}
	@Override
	public String toString() {
		return "SearchQuery [origin=" + flightNumber + ", destination=" + newInventory + ", flightDate=" + flightDate + "]";
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getNewInventory() {
		return newInventory;
	}

	public void setNewInventory(Integer newInventory) {
		this.newInventory = newInventory;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}


	
	
}