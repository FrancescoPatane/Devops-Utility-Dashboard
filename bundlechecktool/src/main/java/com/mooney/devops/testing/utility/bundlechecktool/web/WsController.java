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

import com.mooney.devops.testing.utility.bundlechecktool.comparator.BundleComparator;
import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.BundleComparison;
import com.mooney.devops.testing.utility.bundlechecktool.web.dto.EndpointDto;
import com.mooney.devops.testing.utility.bundlechecktool.web.dto.ResponseDto;


@RestController()
public class WsController {
	
	private static final Logger logger = LoggerFactory.getLogger(WsController.class);

	
	@Autowired
	BundleComparator bundleComparator;
	
	
	@GetMapping("/services")
	public ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request){
		String baseUrl = this.getBaseUrl(request);
		List<EndpointDto> endpoints = new ArrayList<>();
		EndpointDto dto = new EndpointDto(baseUrl + "/compare", "POST", "PARAMS_TO_JSON");
		endpoints.add(dto);
		return ResponseEntity.ok(endpoints);
	}
	
	@PostMapping("/compare")
	public ResponseEntity<ResponseDto> compare(@RequestBody Map<String, String> payload){
		try {
			String env1 = payload.get("env1");
			String env2 = payload.get("env2");
			List<BundleComparison> data = bundleComparator.compareBundles(env1, env2);
			ResponseDto responseData = new ResponseDto(data, "Success");
			return ResponseEntity.ok(responseData);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ResponseDto response = new ResponseDto(e.getClass().toString() + " - " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	private String getBaseUrl(HttpServletRequest req) {
	    return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
	}

}
