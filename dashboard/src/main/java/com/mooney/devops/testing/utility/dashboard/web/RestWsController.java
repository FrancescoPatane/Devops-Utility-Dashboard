package com.mooney.devops.testing.utility.dashboard.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWsController {
	
	@Autowired
	HttpClientComponent httpClient;
	
	@Autowired
	Map<String, String> appsNameUrlMap;
	
	@GetMapping("/call/{app}")
	public ResponseEntity<Object> sendGetRequestToUri(@PathVariable String app) {
		String result = this.httpClient.sendGetRequest(this.appsNameUrlMap.get(app));
		return ResponseEntity.ok(result);
	}

}