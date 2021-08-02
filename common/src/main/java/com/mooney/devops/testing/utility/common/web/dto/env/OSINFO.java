package com.mooney.devops.testing.utility.common.web.dto.env; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class OSINFO{
    @JsonProperty("HOST") 
    public String host;
    @JsonProperty("Name") 
    public String name;
    @JsonProperty("MEM") 
    public MEM mem;
    @JsonProperty("SWAP") 
    public SWAP swap;
    @JsonProperty("Docker data-root") 
    public DockerDataRoot dockerDataRoot;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MEM getMem() {
		return mem;
	}
	public void setMem(MEM mem) {
		this.mem = mem;
	}
	public SWAP getSwap() {
		return swap;
	}
	public void setSwap(SWAP swap) {
		this.swap = swap;
	}
	public DockerDataRoot getDockerDataRoot() {
		return dockerDataRoot;
	}
	public void setDockerDataRoot(DockerDataRoot dockerDataRoot) {
		this.dockerDataRoot = dockerDataRoot;
	}
    
    
    
}
