package com.mooney.devops.testing.utility.common.web.dto.env; 
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty; 
public class KARAF{
	
	
    @JsonProperty("CONTAINER") 
    public String container;
    
    
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
    
    
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}

	public Map<String, Boolean> getPaxWebPorts() {
		return paxWebPorts;
	}

	public void setPaxWebPorts(Map<String, Boolean> paxWebPorts) {
		this.paxWebPorts = paxWebPorts;
	}
    
    
}
