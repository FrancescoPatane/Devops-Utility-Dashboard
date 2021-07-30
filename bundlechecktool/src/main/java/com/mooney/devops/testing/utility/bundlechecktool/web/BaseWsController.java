package com.mooney.devops.testing.utility.bundlechecktool.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.common.web.AbstractRestCatalogueController;
import com.mooney.devops.testing.utility.common.web.dto.EndpointDto;


@RestController()
public class BaseWsController extends AbstractRestCatalogueController{
	
	
	@GetMapping("/")
	public ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request){
		String baseUrl = super.getBaseUrl(request);
		List<EndpointDto> endpoints = new ArrayList<>();
		List<String> paramsCompare = new ArrayList<>(2);
		paramsCompare.add("env1");
		paramsCompare.add("env2");
		EndpointDto dto = new EndpointDto(baseUrl + "/compare", "POST", "HOSTS_TO_FILE", paramsCompare, null);
		endpoints.add(dto);
		return ResponseEntity.ok(endpoints);
	}
	

	

}
