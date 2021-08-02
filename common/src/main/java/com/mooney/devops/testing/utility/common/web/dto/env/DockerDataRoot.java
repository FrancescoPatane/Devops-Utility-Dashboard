package com.mooney.devops.testing.utility.common.web.dto.env; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class DockerDataRoot{
    @JsonProperty("FS") 
    public String fS;
    @JsonProperty("Dim.") 
    public String dim;
    @JsonProperty("Usati") 
    public String usati;
    @JsonProperty("Dispon.") 
    public String dispon;
    @JsonProperty("Uso%") 
    public String uso;
    @JsonProperty("Montato su") 
    public String montatoSu;
}
