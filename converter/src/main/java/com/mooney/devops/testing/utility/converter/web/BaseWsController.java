package com.mooney.devops.testing.utility.converter.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mooney.devops.testing.utility.converter.web.dto.EndpointDto;

@RestController()
public class BaseWsController {
	
	
	@GetMapping("/services")
	public ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request){
		String baseUrl = this.getBaseUrl(request);
		List<EndpointDto> endpoints = new ArrayList<>();
		EndpointDto dto = new EndpointDto(baseUrl + "/udp/toJson", "POST", "JSON_TO_JSON");
		endpoints.add(dto);
		return ResponseEntity.ok(endpoints);
	}
	
	private String getBaseUrl(HttpServletRequest req) {
	    return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
	}

}
