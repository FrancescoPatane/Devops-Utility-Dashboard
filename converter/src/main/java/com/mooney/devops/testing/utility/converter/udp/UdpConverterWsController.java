package com.mooney.devops.testing.utility.converter.udp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class UdpConverterWsController {
	
	@Autowired
	private UdpConverter converter;

	
	@PostMapping("/udp/toJson")
	public ResponseEntity<String> convertUdpToJson(@RequestBody Map<String, String> payload) {
		try {
			String result = converter.convertUdpToJsonString(payload.get("payload"));
			System.out.println(result);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>("Errore non gestito.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
