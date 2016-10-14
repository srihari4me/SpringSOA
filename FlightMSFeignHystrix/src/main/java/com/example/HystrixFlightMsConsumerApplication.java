package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableSwagger2
@RibbonClient(name="flight-microservice", configuration=LoadBalancerConfiguration.class)
@EnableHystrix
@EnableHystrixDashboard
public class HystrixFlightMsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixFlightMsConsumerApplication.class, args);
	}
}
