package com.mooney.devops.testing.utility.common.web.dto.env;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bundle {
	
	@JsonProperty("ID") 
	private String id;
	@JsonProperty("NAME") 
	private String name;
	@JsonProperty("VER") 
	private String version;
	@JsonProperty("STATUS") 
	private String status;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
