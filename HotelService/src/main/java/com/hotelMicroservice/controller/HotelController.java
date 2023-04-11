package com.hotelMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelMicroservice.entities.Hotel;
import com.hotelMicroservice.service.HotelService;
 
@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel createdHotel = this.hotelService.createHotel(hotel);
		return ResponseEntity.status(HttpStatus.OK).body(createdHotel);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> createHotel(@PathVariable String hotelId){
		Hotel createdHotel = this.hotelService.getHotelById(hotelId);
		return ResponseEntity.status(HttpStatus.OK).body(createdHotel);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> createHotel(){
		return ResponseEntity.ok(this.hotelService.getAllHotel());
	}
	
	
}
