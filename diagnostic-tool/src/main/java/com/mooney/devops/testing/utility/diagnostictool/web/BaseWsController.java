package com.mooney.devops.testing.utility.diagnostictool.web;

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
	
	@Override
	@GetMapping("/")
	public ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request){
		String baseUrl = super.getBaseUrl(request);
		List<EndpointDto> endpoints = new ArrayList<>();
		List<String> pathParams = new ArrayList<>(1);
		pathParams.add("env");
		EndpointDto dto = new EndpointDto(baseUrl + "/analyze/{env}", "GET", "ENV_REPORT", "com.mooney.devops.testing.utility.common.web.dto.env.EnvironmentStatusDto", pathParams);
		endpoints.add(dto);
		return ResponseEntity.ok(endpoints);
	}
	

}
