package com.userMicroservice.services;

import java.util.List;

import com.userMicroservice.entitits.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUser();
	
	User getUserById(String userId);
	
	User deleteUser(String userId);
	
	User updateUser(User user, String userId);
	

}
