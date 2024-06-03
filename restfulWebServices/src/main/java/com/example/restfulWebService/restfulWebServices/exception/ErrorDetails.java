package com.example.restfulWebService.restfulWebServices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timestmap ;
	private String message;
	private String details;
	
	public ErrorDetails(LocalDateTime timestmap, String message, String details) {
		super();
		this.timestmap = timestmap;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimestmap() {
		return timestmap;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
	
	
	
}
