package com.mooney.devops.testing.utility.converter.web.dto;

public class EndpointDto {
	
	private String path;
	
	private String requestType;
	
	private String interfaceType;
	
	

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

	public String toJsonString() {
		return "{\"path\":\"" + this.path + "\", \"requestType\":\"" + this.requestType + "\", \"interfaceType\":\"" + this.interfaceType + "\"}";
	}
	
	
	

}
