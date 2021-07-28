package com.mooney.devops.testing.utility.dashboard.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class NavigationController {
	
	
	@Autowired
	private Map<String, String> appsNameUrlMap;
	
	
	
	
	@GetMapping(value = { "/", "/home", "/index" })
	public String home(HttpServletRequest request, HttpServletResponse response, Model uiModel) {
		uiModel.addAttribute("appsNameUrlMap", appsNameUrlMap);
		return "index";
	}
	
	@GetMapping(value = { "/app/{appName}" })
	public String app(@PathVariable String appName, Model uiModel) throws JsonProcessingException {
		uiModel.addAttribute("app", appName);
		return "app";
	}
	
	@GetMapping("/test")
	public String test()  {
		return "test";
	}

}
