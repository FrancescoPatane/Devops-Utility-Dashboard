package com.mooney.devops.testing.utility.dashboard.configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "utility-services") 
public class UtilityServicesConfigProperties {

	private List<String> names;
	private List<String> urls;
	
	private String unit;



	@Bean(name="appsNameUrlMap")
	public Map<String, String> getAppsNameUrlMap() {
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i<names.size(); i++) {
			map.put(names.get(i), urls.get(i));
		}
		return map;
	}



	public String getUnit() {
		return unit;
	}



	public void setUnit(String unit) {
		this.unit = unit;
	}



	public List<String> getNames() {
		return names;
	}



	public void setNames(List<String> names) {
		this.names = names;
	}



	public List<String> getUrls() {
		return urls;
	}



	public void setUrls(List<String> urls) {
		this.urls = urls;
	}
	
	



}
