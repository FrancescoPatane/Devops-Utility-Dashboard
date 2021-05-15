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

@RestController
public class RestWsController {
	
	@Autowired
	HttpClientComponent httpClient;
	
	@Autowired
	Map<String, String> appsNameUrlMap;
	
//	@GetMapping("/call/{app}")
//	public ResponseEntity<Object> sendGetRequestToUri(@PathVariable String app) {
//		String result = this.httpClient.sendGetRequest(this.appsNameUrlMap.get(app));
//		return ResponseEntity.ok(result);
//	}
	
	@PostMapping("/call")
	public ResponseEntity<Object> sendPostRequestToUri(@RequestBody PostRequestDto<String> input) {
		String result = this.httpClient.sendPostRequest(input);
		return ResponseEntity.ok(result);
	}

}
