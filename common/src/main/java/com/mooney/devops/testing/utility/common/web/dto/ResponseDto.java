package com.mooney.devops.testing.utility.common.web.dto;

public class ResponseDto {
	
	private Object payload;
	
	private Boolean succesfull = Boolean.TRUE;
	
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
	
	public ResponseDto(Boolean succesfull, String message) {
		super();
		this.message = message;
		this.succesfull = succesfull;
	}

	public Object getPayload() {
		return payload;
	}

	public String getMessage() {
		return message;
	}

	public boolean getSuccesfull() {
		return succesfull;
	}

	public void setSuccesfull(Boolean succesfull) {
		this.succesfull = succesfull;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	

}
