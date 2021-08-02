package com.mooney.devops.testing.utility.common.web.dto.env; 
import com.fasterxml.jackson.annotation.JsonProperty; 
public class SWAP{
    @JsonProperty("Tot") 
    public String tot;
    @JsonProperty("Used") 
    public String used;
    @JsonProperty("Free") 
    public String free;
}
