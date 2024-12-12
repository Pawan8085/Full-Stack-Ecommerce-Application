package com.app.model;

import com.app.dtos.PaymentInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Order_Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;
	
	@NotNull
	private Long productId;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String user;
	
	@Positive(message = "quantity can't be negative")
	private Integer quantity;
	
	private String image;
	
	@Positive(message = "price can't be negative")
	private Integer price;
	
	@NotNull
	private String product;
	
	 @Enumerated(EnumType.STRING)
	private PaymentType paymentType;
	 
	 @Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	 
	 @Enumerated(EnumType.STRING)
	 private OrderStatus orderStatus = OrderStatus.PENDING;
	 
	 
	 @Transient
	 private PaymentInfo paymentInfo;
}
