package com.mooney.devops.testing.utility.converter.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.common.web.AbstractServiceRestController;
import com.mooney.devops.testing.utility.common.web.dto.EndpointDto;

@RestController()
public class BaseWsController extends AbstractServiceRestController{
	
	@Override
	@GetMapping("/services")
	public ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request){
		String baseUrl = super.getBaseUrl(request);
		List<EndpointDto> endpoints = new ArrayList<>();
		EndpointDto dto = new EndpointDto(baseUrl + "/udp/toJson", "POST", "TEXT_TO_JSON");
		endpoints.add(dto);
		return ResponseEntity.ok(endpoints);
	}
	

}
