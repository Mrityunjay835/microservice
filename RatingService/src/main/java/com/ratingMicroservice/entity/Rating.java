package com.ratingMicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="micro_rating")
public class Rating {
	
	@Id
	private String ratingId;
	
	private String userId;
	
	private String hotelId;
	
	private int rating;
	
	private String feedback;

}