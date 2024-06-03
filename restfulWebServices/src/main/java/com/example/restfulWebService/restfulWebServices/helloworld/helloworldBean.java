package com.example.restfulWebService.restfulWebServices.helloworld;


public class helloworldBean {

	
	private String message;

	public helloworldBean(String message) {
		
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "helloworldBean [message=" + message + "]";
	}
	 
	
}
