package com.mooney.devops.testing.utility.dashboard.web.dto;

public class EndpointDto {
	
	private String path;
	
	private String requestType;
	
	private String interfaceType;
	

	public EndpointDto() {
		super();
	}

	public EndpointDto(String path, String requestType, String interfaceType) {
		super();
		this.path = path;
		this.requestType = requestType;
		this.interfaceType = interfaceType;
	}

	public String getPath() {
		return path;
	}

	public String getRequestType() {
		return requestType;
	}

	public String getInterfaceType() {
		return interfaceType;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public void setInterfaceType(String interfaceType) {
		this.interfaceType = interfaceType;
	}

	public String toJsonString() {
		return "{\"path\":\"" + this.path + "\", \"requestType\":\"" + this.requestType + "\", \"interfaceType\":\"" + this.interfaceType + "\"}";
	}
	
	
	

}
