package com.mooney.devops.testing.utility.diagnostictool.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mooney.devops.testing.utility.common.web.AbstractRestServiceController;

@RestController()
public class DiagnosticRestServiceController extends AbstractRestServiceController{
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@GetMapping("/parse")
	public ResponseEntity<TestDto> getServiceList(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		TestDto result = objectMapper.readValue(new File("test.json"), TestDto.class);
		return ResponseEntity.ok(result);
	}
	

}
