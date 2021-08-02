package com.mooney.devops.testing.utility.common.web.dto.env; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class CONTAINERALL{
    @JsonProperty("NAME") 
    public String name;
    @JsonProperty("IMAGES") 
    public String images;
    @JsonProperty("STATUS") 
    public String status;
    @JsonProperty("PORTS") 
    public String ports;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPorts() {
		return ports;
	}
	public void setPorts(String ports) {
		this.ports = ports;
	}
    
    
    
}
