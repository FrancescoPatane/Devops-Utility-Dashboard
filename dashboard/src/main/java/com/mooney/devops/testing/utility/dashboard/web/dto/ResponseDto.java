package com.mooney.devops.testing.utility.dashboard.web.dto;

public class ResponseDto<T> {
	
	private T payload;
	
	private boolean succesfull;
	
	private String message;
	
	public void setPayload(T payload) {
		this.payload = payload;
	}

	public void setSuccesfull(boolean succesfull) {
		this.succesfull = succesfull;
	}

	public void setMessage(String message) {
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
