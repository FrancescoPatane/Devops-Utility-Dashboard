package com.mooney.devops.testing.utility.converter.web.dto;

public class ResponseDto<T> {
	
	private T payload;
	
	private boolean succesfull;
	
	private String message;
	
	public ResponseDto(String message) {
		super();
		this.message = message;
	}
	
	public ResponseDto(T payload, String message) {
		super();
		this.payload = payload;
		this.message = message;
	}

	public T getPayload() {
		return payload;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccesfull() {
		return succesfull;
	}
	
	
	

}
