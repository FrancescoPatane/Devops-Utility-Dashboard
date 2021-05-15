package com.mooney.devops.testing.utility.converter.udp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.converter.web.dto.ResponseDto;

@RestController
@CrossOrigin("*")
public class UdpConverterWsController {
	
	private static final Logger logger = LoggerFactory.getLogger(UdpConverterWsController.class);

	
	@Autowired
	private UdpConverter converter;

	
	@PostMapping("/udp/toJson")
	public ResponseEntity<ResponseDto<String>> convertUdpToJson(@RequestBody Map<String, String> payload) {
		try {
			String json = converter.convertUdpToJsonString(payload.get("payload"));
			ResponseDto<String>  response = new ResponseDto<>(json, "Success");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			ResponseDto<String>  response = new ResponseDto<>(e.getClass().toString() + " - " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
