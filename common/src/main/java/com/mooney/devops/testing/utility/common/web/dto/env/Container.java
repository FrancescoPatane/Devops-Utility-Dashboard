package com.mooney.devops.testing.utility.common.web.dto.env;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Container {
	
	
	@JsonProperty("CONTAINER") 
	private String name;
	
    @JsonProperty("PAX_WEB_PORTS") 
    public Map<String, Boolean> paxWebPorts;
    
    @JsonProperty("BUNDLE_STATUS") 
    public List<Bundle> bundleStatus;
    
    @JsonProperty("CAMEL_ROUTE_STOPPED") 
    public List<CamelRoute> camelRouteStopped;
    
	public List<Bundle> getBundleStatus() {
		return bundleStatus;
	}

	public void setBundleStatus(List<Bundle> bundleStatus) {
		this.bundleStatus = bundleStatus;
	}

	public List<CamelRoute> getCamelRouteStopped() {
		return camelRouteStopped;
	}

	public void setCamelRouteStopped(List<CamelRoute> camelRouteStopped) {
		this.camelRouteStopped = camelRouteStopped;
	}
    
	public Map<String, Boolean> getPaxWebPorts() {
		return paxWebPorts;
	}

	public void setPaxWebPorts(Map<String, Boolean> paxWebPorts) {
		this.paxWebPorts = paxWebPorts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
