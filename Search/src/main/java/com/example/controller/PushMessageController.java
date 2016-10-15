package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushMessageController {
	
	@Autowired
	private RabbitMessagingTemplate template;
	
	@RequestMapping(value="/send",method=RequestMethod.POST)
	@ResponseStatus(code=HttpStatus.OK)
	public void send(@RequestBody SearchRabbitMQ message) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("FLIGHT_NUMBER", message.getFlightNumber());
		map.put("FLIGHT_DATE", message.getFlightDate());
		map.put("NEW_INVENTORY", message.getNewInventory());
		
		template.convertAndSend("inventoryQ", map);
		
	}
}
