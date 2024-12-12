package com.app.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderId {
	
	@NotNull
	private Long orderId;
}
