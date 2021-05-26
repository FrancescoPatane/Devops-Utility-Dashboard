package com.mooney.devops.testing.utility.bundlechecktool.web.dto;

public class ResponseDto {
	
	private Object payload;
	
	private boolean succesfull;
	
	private String message;
	
	public ResponseDto(String message) {
		super();
		this.message = message;
	}
	
	public ResponseDto(Object payload, String message) {
		super();
		this.payload = payload;
		this.message = message;
	}

	public Object getPayload() {
		return payload;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccesfull() {
		return succesfull;
	}
	
	
	

}
