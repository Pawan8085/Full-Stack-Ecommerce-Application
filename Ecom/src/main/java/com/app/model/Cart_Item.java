package com.app.model;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cart_Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartItemId;
	private Long productId;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String user;
	private Integer quantity;
	private String image;
	private Integer price;
	private String product;
	
	
	
	
	
}
