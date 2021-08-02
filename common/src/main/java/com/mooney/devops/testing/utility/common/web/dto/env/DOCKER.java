package com.mooney.devops.testing.utility.common.web.dto.env; 
import com.fasterxml.jackson.annotation.JsonProperty; 
import java.util.List; 
public class DOCKER{
    @JsonProperty("CONTAINER_RUNNING") 
    public List<String> containerRunning;
    @JsonProperty("CONTAINER_ALL") 
    public List<CONTAINERALL> containerAll;
    @JsonProperty("KARAF") 
    public KARAF karaf;
	public List<String> getContainerRunning() {
		return containerRunning;
	}
	public void setContainerRunning(List<String> containerRunning) {
		this.containerRunning = containerRunning;
	}
	public List<CONTAINERALL> getContainerAll() {
		return containerAll;
	}
	public void setContainerAll(List<CONTAINERALL> containerAll) {
		this.containerAll = containerAll;
	}
	public KARAF getKaraf() {
		return karaf;
	}
	public void setKaraf(KARAF karaf) {
		this.karaf = karaf;
	}
    
    
}
