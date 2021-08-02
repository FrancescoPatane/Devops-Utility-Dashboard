package com.mooney.devops.testing.utility.common.web.dto.env;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EnvironmentStatusDto {
	
    @JsonProperty("OS_INFO") 
    public OSINFO osInfo;
    
    @JsonProperty("DOCKER") 
    public DOCKER docker;

	public OSINFO getOsInfo() {
		return osInfo;
	}

	public void setOsInfo(OSINFO osInfo) {
		this.osInfo = osInfo;
	}

	public DOCKER getDocker() {
		return docker;
	}

	public void setDocker(DOCKER docker) {
		this.docker = docker;
	}
    
    

    
    

}
