package com.mooney.devops.testing.utility.common.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.mooney.devops.testing.utility.common.web.dto.EndpointDto;


public abstract class AbstractRestCatalogueController {
	
	public abstract ResponseEntity<List<EndpointDto>> getServiceList(HttpServletRequest request);

	protected String getBaseUrl(HttpServletRequest req) {
	    return req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath();
	}
}
