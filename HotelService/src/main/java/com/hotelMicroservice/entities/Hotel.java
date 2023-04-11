package com.hotelMicroservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_hotel")
public class Hotel {
	@Id
	private String id;
	
	private String name;
	
	private String location;
	
	private String about;
	
	@Transient
	private List<Rating> ratings=new ArrayList<>();

}
