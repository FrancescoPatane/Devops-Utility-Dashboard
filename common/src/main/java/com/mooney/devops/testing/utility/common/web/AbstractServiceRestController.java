package com.mooney.devops.testing.utility.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.mooney.devops.testing.utility.common.web.dto.EndpointDto;


public abstract class AbstractServiceRestController {
	
	@GetMapping("/services")
	public abstract ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request);

	protected String getBaseUrl(HttpServletRequest req) {
	    return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
	}
}
