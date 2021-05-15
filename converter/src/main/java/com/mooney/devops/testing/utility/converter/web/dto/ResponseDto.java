package com.mooney.devops.testing.utility.converter.web.dto;

public class ResponseDto<T> {
	
	private T payload;
	
	private boolean succesfull;
	
	private String message;
	
	public ResponseDto(String message, boolean sucesfull) {
		super();
		this.message = message;
		this.succesfull = sucesfull;
	}
	
	public ResponseDto(T payload, String message, boolean succesfull) {
		super();
		this.payload = payload;
		this.message = message;
		this.succesfull = succesfull;
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
