package com.hotelMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelMicroservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
