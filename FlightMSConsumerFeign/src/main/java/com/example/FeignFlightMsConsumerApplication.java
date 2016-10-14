package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableSwagger2
@RibbonClient(name="flight-microservice", configuration=LoadBalancerConfiguration.class)
public class FeignFlightMsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignFlightMsConsumerApplication.class, args);
	}
}
