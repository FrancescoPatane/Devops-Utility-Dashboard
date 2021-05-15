package com.mooney.devops.testing.utility.dashboard.web.dto;

public class PostRequestDto<T> {
	
	private String path;
	
	private T payload;
	

	public PostRequestDto(String path,T payload) {
		super();
		this.path = path;
		this.payload = payload;
	}
	
	

	public String getPath() {
		return path;
	}



	public T getPayload() {
		return payload;
	}


}
