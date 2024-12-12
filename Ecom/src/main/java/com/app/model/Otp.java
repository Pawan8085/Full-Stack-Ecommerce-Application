package com.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Otp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long otpId;
	private String otp;
	private String user;
	private LocalDateTime expiryTime;
	
	
	
	
}
