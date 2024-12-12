package com.app.dtos;

import lombok.Data;

@Data
public class ResetPasswordRequest {
	
	private String email;
	private String otp;
	private String newPassword;
}
