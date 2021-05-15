package com.mooney.devops.testing.utility.dashboard.web.dto;

public class ResponseDto {
	
	private String payload;
	
	private boolean succesfull;
	
	private String message;
	
	public void setPayload(String payload) {
		this.payload = payload;
	}

	public void setSuccesfull(boolean succesfull) {
		this.succesfull = succesfull;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPayload() {
		return payload;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccesfull() {
		return succesfull;
	}
	
	
	

}
