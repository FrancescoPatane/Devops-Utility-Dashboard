package com.mooney.devops.testing.utility.bundlechecktool.web.dto;

public class ResponseDto<T> {
	
	private T payload;
	
	private Boolean succesfull;
	
	private String message;
	
	public ResponseDto(String message) {
		super();
		this.message = message;
	}
	
	public ResponseDto(T payload, Boolean succesfull, String message) {
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
