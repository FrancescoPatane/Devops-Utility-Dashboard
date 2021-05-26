package com.mooney.devops.testing.utility.dashboard.web.dto;

import java.util.ArrayList;
import java.util.List;

public class EndpointDto {
	
	private String path;
	
	private String requestType;
	
	private String interfaceType;
	
	private List<String> inputParams;
	

	public EndpointDto() {
		super();
	}

	public EndpointDto(String path, String requestType, String interfaceType) {
		super();
		this.path = path;
		this.requestType = requestType;
		this.interfaceType = interfaceType;
		this.inputParams = new ArrayList<>(0);
	}
	
	public EndpointDto(String path, String requestType, String interfaceType, List<String> params) {
		super();
		this.path = path;
		this.requestType = requestType;
		this.interfaceType = interfaceType;
		this.inputParams = params;
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
	
	public List<String> getInputParams() {
		return inputParams;
	}

	public String toJsonString() {
		return "{\"path\":\"" + this.path + "\", \"requestType\":\"" + this.requestType + "\", \"interfaceType\":\"" + this.interfaceType + "\"}";
	}
	
	
	

}
