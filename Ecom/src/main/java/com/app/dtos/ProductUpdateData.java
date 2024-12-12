package com.app.dtos;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductUpdateData {
	
	@NotNull(message = "productId can not be null")
	private Long productId;
	
	private String productName;
	private String productDescription;
	private Integer price;
	private String image;
	private Long stocks;
}
