package com.userMicroservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userMicroservice.entitits.User;
import com.userMicroservice.exception.ResourceNotFoundException;
import com.userMicroservice.repository.UserRepository;
import com.userMicroservice.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	

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
		return this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User id not found in server"));
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