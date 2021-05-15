package com.mooney.devops.testing.utility.dashboard.web;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.type.TypeReference;
import com.mooney.devops.testing.utility.dashboard.web.dto.EndpointDto;
import com.mooney.devops.testing.utility.dashboard.web.dto.PostRequestDto;

import reactor.core.publisher.Mono;

@Component
public class HttpClientComponent {
	
	private WebClient client = WebClient.create();
	
	
	public String sendGetRequest(String uri) {
		return client.get().uri(uri).retrieve().bodyToMono(String.class).block();
	}
	
	public String sendPostRequest(PostRequestDto<String> requestData) {
		return client.post().uri(requestData.getPath())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(requestData), PostRequestDto.class)
				.retrieve()
		        .bodyToMono(String.class)
		        .block();
	}

}
