package com.userMicroservice.service;

import java.util.List;

import com.userMicroservice.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotelById(String hotelId);
}
