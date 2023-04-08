package com.userMicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userMicroservice.entitits.User;

public interface UserRepository  extends JpaRepository<User, String>{

}
