package com.mooney.devops.testing.utility.dashboard.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mooney.devops.testing.utility.dashboard.web.dto.EndpointDto;


@Controller
public class NavigationController {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private Map<String, String> appsNameUrlMap;
	
	@Autowired
	private HttpClientComponent httpClient;
	
	
	
	@GetMapping(value = { "/", "/home", "/index" })
	public String home(HttpServletRequest request, HttpServletResponse response, Model uiModel) {
		uiModel.addAttribute("appsNameUrlMap", appsNameUrlMap);
		return "index";
	}
	
	@GetMapping(value = { "/app/{appName}" })
	public String app(@PathVariable String appName, Model uiModel) throws JsonProcessingException {
		String serviceListJson = this.httpClient.sendGetRequest(this.appsNameUrlMap.get(appName));
		List<EndpointDto> serviceList = mapper.readValue(serviceListJson, new TypeReference<List<EndpointDto>>(){});
		uiModel.addAttribute("serviceList", serviceList);
		return "app";
	}

}
