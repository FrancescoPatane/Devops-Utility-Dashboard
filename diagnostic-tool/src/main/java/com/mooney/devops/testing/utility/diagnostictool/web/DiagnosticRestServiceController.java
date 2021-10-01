package com.mooney.devops.testing.utility.diagnostictool.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mooney.devops.testing.utility.common.web.AbstractRestServiceController;
import com.mooney.devops.testing.utility.common.web.dto.ResponseDto;
import com.mooney.devops.testing.utility.common.web.dto.env.EnvironmentStatusDto;
import com.mooney.devops.testing.utility.diagnostictool.ssh.RemoteSshExecutor;

@RestController()
public class DiagnosticRestServiceController extends AbstractRestServiceController{
	
	private static final Logger logger = LoggerFactory.getLogger(DiagnosticRestServiceController.class);
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Autowired
	private RemoteSshExecutor sshExec;
	
	@GetMapping("/parse")
	public ResponseEntity<TestDto> getServiceList(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException{
		TestDto result = objectMapper.readValue(new File("test.json"), TestDto.class);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/analyze/{target}")
	public ResponseEntity<ResponseDto> analyze(HttpServletRequest request, @PathVariable String target) {
		logger.info("START - analyze {}", target);
		String output = this.sshExec.execRemoteSh(target);
		EnvironmentStatusDto result = null;
		try {
			result = this.objectMapper.readValue(output, EnvironmentStatusDto.class);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			ResponseDto responseData = new ResponseDto(e.getMessage() + " - " + "Remote server analysys output is not valid json");
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		result.getDocker().getKaraf().getServices().stream();
		ResponseDto response = new ResponseDto(result, "Success");
		return ResponseEntity.ok(response);
	}
	

}
