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
	public ResponseEntity<Object> sendGetRequestToUri(@PathVariable String app) {
		String serviceListJson = this.httpClient.sendGetRequest(this.appsNameUrlMap.get(app));
		return ResponseEntity.ok(serviceListJson);
	}
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/call")
	public ResponseEntity sendPostRequestToUri(@RequestBody PostRequestDto input) {
		ResponseDto result = this.httpClient.sendPostRequest(input);
		
		if(result.getPayload() instanceof byte[]) {
			return ResponseEntity.ok(result);
		}else {
			return ResponseEntity.ok(result);
		}
		
		
	}

}
