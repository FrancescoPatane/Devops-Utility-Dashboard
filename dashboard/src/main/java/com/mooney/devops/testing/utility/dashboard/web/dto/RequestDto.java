package com.mooney.devops.testing.utility.dashboard.web.dto;

public class RequestDto {
	
	private String path;
	
	private String payload;
	
	private String httpMethod = "POST";
	
	private String dtoClass;
	

	public String getHttpMethod() {
		return httpMethod;
	}



	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}



	public void setPath(String path) {
		this.path = path;
	}



	public void setPayload(String payload) {
		this.payload = payload;
	}



	public String getPath() {
		return path;
	}



	public String getPayload() {
		return payload;
	}



	public String getDtoClass() {
		return dtoClass;
	}



	public void setDtoClass(String dtoClass) {
		this.dtoClass = dtoClass;
	}
	
	


}
