package com.example.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="rest_flights") // Equivalent to @Entity
public class Flight {
	
	@Id
	private Integer id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-mm-dd hh:MM:ss")
	private Date startTime;
	
	private String destinationName;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(Integer id, Date startTime, String destinationName) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.destinationName = destinationName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	
}
