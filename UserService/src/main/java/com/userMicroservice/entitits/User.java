package com.userMicroservice.entitits;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="micro_user")
@Getter
@Setter
@NoArgsConstructor
public class User {
	
	@Id
	private String userId;
	
	private String name;
	
	private String email;
	                                                                                                      
	private String about;
	
	@Transient
	private List<Rating> rating = new ArrayList<>();
}
