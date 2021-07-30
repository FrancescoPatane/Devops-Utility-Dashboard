package com.mooney.devops.testing.utility.common.web.dto;

public class ResponseDto {
	
	private Object payload;
	
	private Boolean succesfull;
	
	private String message;
	
	public ResponseDto() {
	}
	
	public ResponseDto(String message) {
		super();
		this.message = message;
	}
	
	public ResponseDto(Object payload, String message) {
		super();
		this.payload = payload;
		this.message = message;
	}
	
	public ResponseDto(Object payload, Boolean succesfull, String message) {
		super();
		this.payload = payload;
		this.message = message;
		this.succesfull = succesfull;
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

	public void setSuccesfull(Boolean succesfull) {
		this.succesfull = succesfull;
	}
	
	
	

}
