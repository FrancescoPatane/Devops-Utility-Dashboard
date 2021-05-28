package com.mooney.devops.testing.utility.dashboard.web.dto;

public class PostRequestDto {
	
	private String path;
	
	private String payload;
	

	public PostRequestDto(String path,String payload) {
		super();
		this.path = path;
		this.payload = payload;
	}
	
	

	public String getPath() {
		return path;
	}



	public String getPayload() {
		return payload;
	}


}
