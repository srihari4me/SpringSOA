package com.example;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix="newConfig") // newConfig is the property defined bootstrap.yml file of the producer service
@RefreshScope
public class CloudBusRestController {
	
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	@RequestMapping("/")
	public ResponseEntity<String> getConfigInfo() {
		return new ResponseEntity<String>(getData(), HttpStatus.OK);
	}
}
