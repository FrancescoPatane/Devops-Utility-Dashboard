package com.mooney.devops.testing.utility.bundlechecktool.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooney.devops.testing.utility.bundlechecktool.comparator.BundleComparator;
import com.mooney.devops.testing.utility.common.web.AbstractRestServiceController;
import com.mooney.devops.testing.utility.common.web.dto.FileTransferDto;
import com.mooney.devops.testing.utility.common.web.dto.InputEnvComparisonDto;
import com.mooney.devops.testing.utility.common.web.dto.ResponseDto;

@RestController()
public class BundleComparatorWsController extends AbstractRestServiceController{

	private static final Logger logger = LoggerFactory.getLogger(BundleComparatorWsController.class);

	@Autowired
	BundleComparator bundleComparator;

	@PostMapping("/compare")
	public ResponseEntity<ResponseDto> compareBundles(@RequestBody InputEnvComparisonDto input){
		logger.info("convertUdpToJson - compareBundles");
		ResponseEntity<ResponseDto> response;
		ResponseDto responseData;
		String env1 = input.getEnv1();
		String env2 = input.getEnv2();
		FileTransferDto file = bundleComparator.compareBundles(env1, env2);
		responseData = new ResponseDto(file, "Success");
		response = ResponseEntity.ok(responseData);
		return response;
	}

}
