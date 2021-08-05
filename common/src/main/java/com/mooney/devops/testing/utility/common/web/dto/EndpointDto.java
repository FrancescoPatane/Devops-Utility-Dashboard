package com.mooney.devops.testing.utility.common.web.dto;

import java.util.ArrayList;
import java.util.List;

public class EndpointDto {
	
	private String path;
	
	private String requestType;
	
	private String interfaceType;
	
	private List<String> inputParams;
	
	private List<String> pathParams;
	
	

	public EndpointDto(String path, String requestType, String interfaceType) {
		super();
		this.path = path;
		this.requestType = requestType;
		this.interfaceType = interfaceType;
		this.inputParams = new ArrayList<>(0);
		this.pathParams = new ArrayList<>(0);
	}
	
	public EndpointDto(String path, String requestType, String interfaceType, List<String> inputParams, List<String> pathParams) {
		super();
		this.path = path;
		this.requestType = requestType;
		this.interfaceType = interfaceType;
		this.inputParams = inputParams;
		this.pathParams = pathParams;
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

	public List<String> getPathParams() {
		return pathParams;
	}


	
	
	

}
