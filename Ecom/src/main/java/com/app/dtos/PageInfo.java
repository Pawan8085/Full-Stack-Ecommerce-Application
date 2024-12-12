package com.app.dtos;

import lombok.Data;

@Data
public class PageInfo {
	
	private int currentPage;
	private int totalPages;
	private int totalRecords;
	private int recordPerPage;
}
