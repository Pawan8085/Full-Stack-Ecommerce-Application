package com.app.dtos;


import lombok.Data;

@Data
public class PaymentInfo {
	
	
	private String id;
	private Integer amount;
	private String currency;
	private String status;
}
