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
		String output = "{ \"OS_INFO\": { \"HOST\":\"10.76.80.4\", \"Name\":\"s1npspas01.sisalpay5group.local\", \"MEM\": { \"Tot\": \"15G\", \"Used\": \"4,1G\", \"Free\": \"253M\", \"Available\": \"10G\" }, \"SWAP\": { \"Tot\": \"8,0G\", \"Used\": \"713M\", \"Free\": \"7,3G\" }, \"Docker data-root\": { \"FS\": \"/dev/mapper/vg_system-lv_app\", \"Dim.\": \"50G\", \"Usati\": \"8,2G\", \"Dispon.\": \"42G\", \"Uso%\": \"17%\", \"Montato su\": \"/usr/local/app\" } }, \"DOCKER\": { \"CONTAINER_ALL\": [ { \"NAME\": \"sfe\", \"IMAGES\": \"fra.ocir.io/sisalspa/sisalpay/nps/sfe-image:0.1.9-dev \", \"STATUS\": \"Up 6 days \", \"PORTS\": \"0.0.0.0:8244->443/tcp, 0.0.0.0:8299->1099/tcp, 0.0.0.0:8205->5005/tcp, 0.0.0.0:8281->8181/tcp, 0.0.0.0:8243->8443/tcp\" }, { \"NAME\": \"adapter\", \"IMAGES\": \"fra.ocir.io/sisalspa/sisalpay/nps/adapter-image:0.1.11-dev \", \"STATUS\": \"Up 9 days \", \"PORTS\": \"0.0.0.0:60001->60001/udp, 0.0.0.0:8399->1099/tcp, 0.0.0.0:8305->5005/tcp, 0.0.0.0:8381->8181/tcp, 0.0.0.0:8343->8443/tcp\" }, { \"NAME\": \"swebs\", \"IMAGES\": \"fra.ocir.io/sisalspa/sisalpay/nps/swebs-image:0.1.13-dev \", \"STATUS\": \"Up 9 days \", \"PORTS\": \"0.0.0.0:8181->8181/tcp, 0.0.0.0:8443->8443/tcp, 0.0.0.0:8499->1099/tcp, 0.0.0.0:8405->5005/tcp\" }, { \"NAME\": \"orchestrator\", \"IMAGES\": \"fra.ocir.io/sisalspa/sisalpay/nps/orchestrator-image:0.1.14-dev \", \"STATUS\": \"Up 9 days \", \"PORTS\": \"0.0.0.0:8599->1099/tcp, 0.0.0.0:8505->5005/tcp, 0.0.0.0:8581->8181/tcp, 0.0.0.0:8543->8443/tcp\" }, { \"NAME\": \"card\", \"IMAGES\": \"fra.ocir.io/sisalspa/sisalpay/nps/card-image:0.1.13-dev \", \"STATUS\": \"Up 9 days \", \"PORTS\": \"0.0.0.0:8699->1099/tcp, 0.0.0.0:8605->5005/tcp, 0.0.0.0:8681->8181/tcp, 0.0.0.0:8643->8443/tcp, 0.0.0.0:8690->9090/tcp\" }, { \"NAME\": \"jms\", \"IMAGES\": \"rmohr/activemq:5.13.3 \", \"STATUS\": \"Up 9 days \", \"PORTS\": \"1883/tcp, 5672/tcp, 0.0.0.0:8161->8161/tcp, 61613-61614/tcp, 0.0.0.0:61616->61616/tcp\" }, { \"NAME\": \"docker-gc\", \"IMAGES\": \"clockworksoul/docker-gc-cron:latest \", \"STATUS\": \"Up 2 weeks \", \"PORTS\": \"\" } ], \"KARAF\": { \"CONTAINER\":\"card\", \"PAX_WEB_PORTS\": { \"org.osgi.service.http.enabled\": true, \"org.osgi.service.http.secure.enabled\": true }, \"BUNDLE_STATUS\": [ { \"ID\":\"290\", \"STATUS\": \"Resolved\", \"VER\": \"1.3.2\", \"NAME\": \"Retefisica NPS :: NCP :: Topup Partner Plugin\" }, { \"ID\":\"291\", \"STATUS\": \"felix.fileinstall.dir\", \"NAME\": \"etc/commons\" }, { \"ID\":\"292\", \"STATUS\": \"felix.fileinstall.dir\", \"NAME\": \"etc/bundle\" } ], \"CAMEL_ROUTE_STOPPED\": [ { \"Name\":\"cardserver-proxy-in\", \"Context\": \"cardserver-proxy-plugin-context\", \"Status\": \"Stopped\", \"Total\": \"0\", \"Failed\": \"0\", \"Inflight\": \"0\" }, { \"Name\":\"cardserver-proxy-out-email\", \"Context\": \"cardserver-proxy-plugin-context\", \"Status\": \"Stopped\", \"Total\": \"0\", \"Failed\": \"0\", \"Inflight\": \"0\" } ] } } }";
		EnvironmentStatusDto result = null;
		try {
			result = this.objectMapper.readValue(output, EnvironmentStatusDto.class);
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
			ResponseDto responseData = new ResponseDto(e.getMessage() + " - " + "Remote server analysys output is not valid json");
			return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		ResponseDto response = new ResponseDto(result, "Success");
		return ResponseEntity.ok(response);
	}
	

}
