package com.mooney.devops.testing.utility.dashboard.web;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class HttpClientComponent {
	
	private WebClient client = WebClient.create();
	
	
	public String sendGetRequest(String uri) {
		return client.get().uri(uri).retrieve().bodyToMono(String.class).block();
	}

}
