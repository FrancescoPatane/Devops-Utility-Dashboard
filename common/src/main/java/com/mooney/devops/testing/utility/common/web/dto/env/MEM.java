package com.mooney.devops.testing.utility.common.web.dto.env; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class MEM{
    @JsonProperty("Tot") 
    public String tot;
    @JsonProperty("Used") 
    public String used;
    @JsonProperty("Free") 
    public String free;
    @JsonProperty("Available") 
    public String available;
	public String getTot() {
		return tot;
	}
	public void setTot(String tot) {
		this.tot = tot;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
    
    
}
