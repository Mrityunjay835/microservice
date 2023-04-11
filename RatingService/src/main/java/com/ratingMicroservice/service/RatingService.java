package com.ratingMicroservice.service;

import java.util.List;

import com.ratingMicroservice.entity.Rating;

public interface RatingService {
	
	//create rating 
	Rating create(Rating rating);
	
	//get all rating 
	List<Rating> getAllRating();
	
	//get all rating by  userId
	
	List<Rating>  getAllRatingByUserId(String userId);
	
	//get all rating of hotelId
	List<Rating> getAllRatingByHotelId(String hotelId);
	
}
