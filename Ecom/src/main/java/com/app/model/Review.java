package com.app.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
	
	@Id
	@GeneratedValue
	private Long reviewId;
	@NotNull
	private String ratingStatus;
	
	@NotNull
	private String description;
	
	@NotNull
	@Min(1)
	@Max(5)
	private Integer rating;
	
	private String customerName;
	private String customerCity;
	
}
