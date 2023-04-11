package com.hotelMicroservice.external.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hotelMicroservice.entities.Rating;

@FeignClient("RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/hotel/{hotelId}")
	List<Rating> getAllRating(@PathVariable String hotelId);
}
