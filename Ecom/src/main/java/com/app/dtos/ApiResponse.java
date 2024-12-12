package com.app.dtos;

import java.util.List;

import lombok.Data;

@Data
public class ApiResponse<T> {
	
	private List<T> data;
	private PageInfo pageInfo;
}
