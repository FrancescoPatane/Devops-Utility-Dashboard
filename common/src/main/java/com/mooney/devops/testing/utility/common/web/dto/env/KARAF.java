package com.mooney.devops.testing.utility.common.web.dto.env; 
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty; 
public class KARAF{
	
	
    @JsonProperty("SERVICES") 
    public List<Container> services;

	public List<Container> getServices() {
		return services;
	}

	public void setServices(List<Container> services) {
		this.services = services;
	}

    
    



    
    
}
