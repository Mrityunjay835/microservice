package com.userMicroservice.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userMicroservice.entities.Hotel;
import com.userMicroservice.exception.ResourceNotFoundException;
import com.userMicroservice.repository.HotelRepository;
import com.userMicroservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;

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
		return this.hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
	}
	
	
}
