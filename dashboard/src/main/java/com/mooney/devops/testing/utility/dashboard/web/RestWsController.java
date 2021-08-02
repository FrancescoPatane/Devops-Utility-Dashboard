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
import com.mooney.devops.testing.utility.dashboard.web.dto.RequestDto;

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
	public ResponseEntity sendPostRequestToUri(@RequestBody RequestDto input) {
		ResponseDto result;
		if (input.getHttpMethod().equals("POST")) {
			result = this.httpClient.sendPostRequest(input);
		}else {
			result = this.httpClient.sendGetRequest(input.getPath(), input.getDtoClass());
		}
		return ResponseEntity.ok(result);
	}
	
//	@SuppressWarnings("rawtypes")
//	@PostMapping("/call/{target}")
//	public ResponseEntity sendGetRequestToUri(@PathVariable String target) {
//		ResponseDto result = this.httpClient.sendGetRequest(target);
//		return ResponseEntity.ok(result);
//	}

}
