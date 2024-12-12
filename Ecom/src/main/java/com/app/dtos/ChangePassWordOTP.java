package com.app.dtos;

import lombok.Data;

@Data
public class ChangePassWordOTP {
	
	private String oldPassword;
	private String newPassword;
	private String otp;
}
