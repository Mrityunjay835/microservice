package com.hotelMicroservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HotelConfiguration {

	@Bean
	@LoadBalanced
	public RestTemplate createRestTemplete() {
		return new RestTemplate();
	}
}
