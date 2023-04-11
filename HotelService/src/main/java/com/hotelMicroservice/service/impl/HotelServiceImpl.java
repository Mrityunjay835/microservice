package com.hotelMicroservice.service.impl;

//import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import com.hotelMicroservice.entities.Hotel;
import com.hotelMicroservice.entities.Rating;
import com.hotelMicroservice.exception.ResourceNotFoundException;
import com.hotelMicroservice.external.service.RatingService;
import com.hotelMicroservice.repository.HotelRepository;
import com.hotelMicroservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private RatingService ratingService;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return this.hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		Hotel hotel= this.hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
		
//		Rating[] ratingsForHotel=restTemplate.getForObject("http://RATING-SERVICE/ratings/hotel/"+hotel.getId(), Rating[].class);
//		
//		List<Rating> ratings  = Arrays.stream(ratingsForHotel).toList();
		
		List<Rating> ratings = ratingService.getAllRating(hotel.getId());
		
		hotel.setRatings(ratings);
		
		return hotel;
	}
	
	
}
