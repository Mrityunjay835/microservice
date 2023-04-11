package com.userMicroservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userMicroservice.entitits.Hotel;
import com.userMicroservice.entitits.Rating;
import com.userMicroservice.entitits.User;
import com.userMicroservice.exception.ResourceNotFoundException;
import com.userMicroservice.repository.UserRepository;
import com.userMicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	private Logger logger =org.slf4j.LoggerFactory.getLogger(UserService.class) ;
	

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User id not found in server"));
		
		//fetch rating of the user 
		//so we need api -> http://localhost:8081/users/505177b1-c618-48e6-96f2-ef4a0f902151
		Rating[]  ratingOfUser  =restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(),Rating[].class);
		
		List<Rating> ratings =Arrays.stream(ratingOfUser).toList();
		
		List<Rating>  ratingList=ratings.stream().map(rating->{
			//api call to get hotel service to get hotel details
			
			
			ResponseEntity<Hotel> forHotelEntity =restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ rating.getHotelId(),Hotel.class);
			//set the hotel to rating's hotel
			Hotel hotel  = forHotelEntity.getBody();
			
			rating.setHotel(hotel);
			//return the rating 
			return rating;
			
		}).collect(Collectors.toList());
		
		
		user.setRating(ratingList);
		
		return user;
	}

	@Override
	public User deleteUser(String userId) {
		User user = getUserById(userId);
	    this.userRepository.delete(user);
	    return user;
		
	} 

	@Override
	public User updateUser(User user, String userId) {
		User userUpdate = getUserById(userId);
		userUpdate.setName(user.getName());
		userUpdate.setEmail(user.getEmail());
		userUpdate.setAbout(user.getAbout());
		return this.userRepository.save(userUpdate);
	}
	
	

}
