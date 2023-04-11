package com.hotelMicroservice.service;

import java.util.List;

import com.hotelMicroservice.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotel();
	
	Hotel getHotelById(String hotelId);
}
