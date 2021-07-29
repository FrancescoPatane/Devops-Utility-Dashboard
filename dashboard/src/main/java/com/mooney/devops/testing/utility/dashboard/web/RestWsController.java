package com.mooney.devops.testing.utility.dashboard.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.common.web.dto.ResponseDto;
import com.mooney.devops.testing.utility.dashboard.web.dto.PostRequestDto;

@RestController
public class RestWsController {
	
	@Autowired
	HttpClientComponent httpClient;
	
	@Autowired
	Map<String, String> appsNameUrlMap;
	
	@GetMapping("/app/{app}/services")
	public ResponseEntity<String> getApplicationServiceList(@PathVariable String app) {
		String serviceListJson = this.httpClient.getExposedServices(this.appsNameUrlMap.get(app));
		return ResponseEntity.ok(serviceListJson);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/call")
	public ResponseEntity sendPostRequestToUri(@RequestBody PostRequestDto input) {
		ResponseDto result = this.httpClient.sendPostRequest(input);
		return ResponseEntity.ok(result);
	}
	
	@SuppressWarnings("rawtypes")
	@GetMapping("/call")
	public ResponseEntity sendGetRequestToUri(@RequestBody String uri) {
		ResponseDto result = this.httpClient.sendGetRequest(uri);
		return ResponseEntity.ok(result);
	}

}
