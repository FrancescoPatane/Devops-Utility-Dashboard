package com.mooney.devops.testing.utility.converter.udp;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.common.web.AbstractRestServiceController;
import com.mooney.devops.testing.utility.common.web.dto.ResponseDto;



@RestController
public class UdpConverterWsController extends AbstractRestServiceController{

	private static final Logger logger = LoggerFactory.getLogger(UdpConverterWsController.class);


	@Autowired
	private UdpConverter converter;


	@PostMapping("/udp/toJson")
	public ResponseEntity<ResponseDto> convertUdpToJson(@RequestBody String payload) {
		logger.info("convertUdpToJson - START");
		String json = converter.convertUdpToJsonString(payload);
		ResponseDto response = new ResponseDto(json, "Success");
		return ResponseEntity.ok(response);
	}


}
