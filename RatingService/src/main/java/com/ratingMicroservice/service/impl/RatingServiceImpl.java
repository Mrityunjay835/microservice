package com.ratingMicroservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingMicroservice.entity.Rating;
import com.ratingMicroservice.repository.RatingRepository;
import com.ratingMicroservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	RatingRepository ratingRepository;

	@Override
	public Rating create(Rating rating) {
		String createRatingId = UUID.randomUUID().toString();
		rating.setRatingId(createRatingId);
		
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		
		return this.ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		
		return this.ratingRepository.findByHotelId(hotelId);
	}

}
