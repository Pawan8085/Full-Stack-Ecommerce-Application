package com.app.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long pId;
	@NotNull(message = "product name can not be null")
	@Size(min=20, message = "product name length should be atleast 20")
	private String productName;
	@NotNull(message = "product description can not be null")
	@Size(min=40, message = "product description length should be atleast 20")
	private String productDescription;
	@NotNull
	@Min(1)
	private Integer price;
	private Double rating;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long ratingSum;
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Long ratingCount;
	@NotNull(message = "product image can not be null")
	private String image;
	@Min(0)
	private Long stocks;
	private Long sold;
	private Boolean isOutOfStock;
	
	public Product() {
		this.sold = 0l;
		this.stocks = 0l;
		this.rating = 0d;
		this.ratingSum = 0l;
		this.ratingCount = 0l;
		this.isOutOfStock = false;
	}
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Review> reviews;
	
	@ManyToOne
	@JsonBackReference
	private Category category;
}
