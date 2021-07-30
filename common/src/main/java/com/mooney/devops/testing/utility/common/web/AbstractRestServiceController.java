package com.mooney.devops.testing.utility.common.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mooney.devops.testing.utility.common.web.dto.ResponseDto;

public abstract class AbstractRestServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(AbstractRestServiceController.class);
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDto> handleGenericException(HttpServletRequest request, Exception e) {
		logger.error("UNMANAGED ERROR");
		logger.error(e.getMessage(), e);
		ResponseDto responseData = new ResponseDto(e.getClass().toString() + " - " + e.getMessage());
		return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
