package com.mooney.devops.testing.utility.bundlechecktool.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mooney.devops.testing.utility.bundlechecktool.comparator.BundleComparator;
import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.BundleComparison;
import com.mooney.devops.testing.utility.bundlechecktool.web.dto.EndpointDto;
import com.mooney.devops.testing.utility.bundlechecktool.web.dto.FileTransferDto;
import com.mooney.devops.testing.utility.bundlechecktool.web.dto.ResponseDto;


@RestController()
public class WsController {
	
	private static final Logger logger = LoggerFactory.getLogger(WsController.class);

	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	BundleComparator bundleComparator;
	
	
	@GetMapping("/services")
	public ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request){
		String baseUrl = this.getBaseUrl(request);
		List<EndpointDto> endpoints = new ArrayList<>();
		List<String> paramsCompare = new ArrayList<>(2);
		paramsCompare.add("env1");
		paramsCompare.add("env2");
		EndpointDto dto = new EndpointDto(baseUrl + "/compare", "POST", "PARAMS_TO_FILE", paramsCompare);
		endpoints.add(dto);
		return ResponseEntity.ok(endpoints);
	}
	
	@PostMapping("/compare")
	public ResponseEntity<ResponseDto<FileTransferDto>> compare(@RequestBody Map<String, Object> payload){
		ResponseEntity<ResponseDto<FileTransferDto>> response;
		ResponseDto<FileTransferDto> responseData;
		try {
			String env1 = (String) payload.get("env1");
			String env2 = (String) payload.get("env2");
			FileTransferDto file = bundleComparator.compareBundles(env1, env2);
			responseData = new ResponseDto<>(file, Boolean.TRUE, "Success");
			response = ResponseEntity.ok(responseData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			responseData = new ResponseDto<>(e.getClass().toString() + " - " + e.getMessage());
			response = new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	private String getBaseUrl(HttpServletRequest req) {
	    return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
	}

}
