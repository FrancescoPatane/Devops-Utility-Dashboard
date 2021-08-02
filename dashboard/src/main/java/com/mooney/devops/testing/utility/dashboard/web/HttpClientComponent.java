package com.mooney.devops.testing.utility.dashboard.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.mooney.devops.testing.utility.common.web.dto.ResponseDto;
import com.mooney.devops.testing.utility.dashboard.web.dto.RequestDto;

import reactor.core.publisher.Mono;

@Component
public class HttpClientComponent {
	
	private WebClient client = WebClient.create();
	
	
	public String getExposedServices(String uri) {
		return client.get().uri(uri).retrieve().bodyToMono(String.class).block();
	}
	
	public ResponseDto sendPostRequest(RequestDto requestData) {
		return client.post().uri(requestData.getPath())
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.body(Mono.just(requestData.getPayload()), String.class)
				.exchangeToMono(response -> {
					boolean succesfull = response.statusCode().equals(HttpStatus.OK);
		             return response.bodyToMono(ResponseDto.class)
		            		 .doOnNext(r -> r.setSuccesfull(succesfull));
			     })
				.block();
	}
	
	public ResponseDto sendGetRequest(String uri, String dtoClass) {
		return client.get().uri(uri)
				.exchangeToMono(response -> {
					boolean succesfull = response.statusCode().equals(HttpStatus.OK);
		             return response.bodyToMono(ResponseDto.class)
		            		 .doOnNext(r -> r.setSuccesfull(succesfull));
			     })
				.block();
	}

}
