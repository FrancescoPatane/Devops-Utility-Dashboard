package com.mooney.devops.testing.utility.common.web.dto.env;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CamelRoute {
	
	@JsonProperty("Name") 
	private String name;
	@JsonProperty("Context") 
	private String context;
	@JsonProperty("Status") 
	private String status;
	@JsonProperty("Total") 
	private Long total;
	@JsonProperty("Inflight") 
	private Long inflight;
	@JsonProperty("Failed") 
	private Long failed;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getInflight() {
		return inflight;
	}
	public void setInflight(Long inflight) {
		this.inflight = inflight;
	}
	public Long getFailed() {
		return failed;
	}
	public void setFailed(Long failed) {
		this.failed = failed;
	}
	
	
	

}
