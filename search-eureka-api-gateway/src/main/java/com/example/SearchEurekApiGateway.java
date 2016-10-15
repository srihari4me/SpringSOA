package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@CrossOrigin
@EnableZuulProxy
@EnableEurekaClient
public class SearchEurekApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(SearchEurekApiGateway.class, args);
	}
}
