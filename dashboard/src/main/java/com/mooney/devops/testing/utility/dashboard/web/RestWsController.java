package com.mooney.devops.testing.utility.dashboard.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.dashboard.web.dto.PostRequestDto;
import com.mooney.devops.testing.utility.dashboard.web.dto.ResponseDto;

@RestController
public class RestWsController {
	
	@Autowired
	HttpClientComponent httpClient;
	
	@Autowired
	Map<String, String> appsNameUrlMap;
	
	@GetMapping("/app/{app}/services")
	public ResponseEntity<Object> sendGetRequestToUri(@PathVariable String app) {
		String serviceListJson = this.httpClient.sendGetRequest(this.appsNameUrlMap.get(app));
		return ResponseEntity.ok(serviceListJson);
	}
	
	@PostMapping("/call")
	public ResponseEntity<Object> sendPostRequestToUri(@RequestBody PostRequestDto input) {
		ResponseDto result = this.httpClient.sendPostRequest(input);
		return ResponseEntity.ok(result);
	}

}
