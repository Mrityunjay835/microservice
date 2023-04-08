package com.userMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMicroservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
