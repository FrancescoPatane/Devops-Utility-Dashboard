package com.mooney.devops.testing.utility.bundlechecktool.comparator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.BundleComparison;
import com.mooney.devops.testing.utility.bundlechecktool.nps.utils.Constants;
import com.mooney.devops.testing.utility.bundlechecktool.nps.utils.Utils;


@Component
public class BundleComparator {
	
	private static final Logger logger = LoggerFactory.getLogger(BundleComparator.class);
	
	@Value("${main.json}")
	private String mainEnvJsonString;
	
	@Value("${to-check.json}")
	private String envToCheckJsonString;
	
	@Value("#{'${bundle.pattern.exclude}'.split(',')}")
	private List<String> bundleExcludePatterns;
	
	@Value("#{'${bundle.pattern.include}'.split(',')}")
	private List<String> bundleIncludePatterns;
	
	@Autowired
	private Environment springEnv;
	

	
	public List<BundleComparison> compareBundles(String env1, String env2) throws Exception {
		
		logger.info("START compareBundles...");  
		
		boolean stubOn = Boolean.parseBoolean(springEnv.getProperty("stubOn"));

		Map<String, String> mainEnvironmentBundles;
		Map<String, String> environmentToCheckBundles;

		boolean bundleInclude = Boolean.parseBoolean(springEnv.getProperty("bundle.include"));
		List<String> bundlesPatternNames;
		if (bundleInclude) {
			bundlesPatternNames = this.bundleIncludePatterns;
		}else {
			bundlesPatternNames = this.bundleExcludePatterns;
		}

		if (stubOn) {
		    mainEnvironmentBundles = Utils.prepareSortedBundleVersionMapStubOn(mainEnvJsonString, bundlesPatternNames, bundleInclude);
		    environmentToCheckBundles = Utils.prepareSortedBundleVersionMapStubOn(envToCheckJsonString, bundlesPatternNames, bundleInclude);
		} 
		else {
		    String mainEnv = env1;
		    String envToCheck = env2;

		    //main env baseUrl + karaf bundle list endopint
		    String mainEnvironmentUrl = springEnv.getProperty(mainEnv) + springEnv.getProperty(Constants.BUNDLE_LIST_ENDPOINT);
		    logger.info("Calling main env url: " + mainEnvironmentUrl);
		    HttpResponse mainEnvHttpResponse = Utils.getKarafHttpResponse(mainEnvironmentUrl, getEnvConsoleUsername(mainEnv, springEnv), getEnvConsolePassword(mainEnv, springEnv));

		    String environmentToCheckUrl = springEnv.getProperty(envToCheck) + springEnv.getProperty(Constants.BUNDLE_LIST_ENDPOINT);
		    logger.info("Calling env to check url: " + environmentToCheckUrl);
		    HttpResponse envToCheckHttpResponse = Utils.getKarafHttpResponse(environmentToCheckUrl, getEnvConsoleUsername(envToCheck, springEnv), getEnvConsolePassword(envToCheck, springEnv));

		    mainEnvironmentBundles = Utils.prepareSortedBundleVersionMap(checkAuth(mainEnvHttpResponse, mainEnvironmentUrl, springEnv), bundlesPatternNames, bundleInclude);
		    environmentToCheckBundles = Utils.prepareSortedBundleVersionMap(checkAuth(envToCheckHttpResponse, environmentToCheckUrl, springEnv), bundlesPatternNames, bundleInclude);            
		}

		List<BundleComparison> bundleComparisons = Utils.getBundleComparisonList(mainEnvironmentBundles, environmentToCheckBundles);

//		logger.info("Preparing excel file... ");
//		WorkbookUtils.createExcelFile(bundleComparisons);
//		logger.info("File created! ");
		logger.info("Environments compared!");
		return bundleComparisons;
	}
	
    private String getEnvConsoleUsername(String env, Environment springEnv) {
	String[] envArray = StringUtils.split(env, "_");		
	return Utils.resolveCreds(springEnv, Constants.CONSOLE_CREDENTIALS_USERNAME_PFX, envArray);
    }

    private String getEnvConsolePassword(String env, Environment springEnv) {
	String[] envArray = StringUtils.split(env, "_");
	return Utils.resolveCreds(springEnv, Constants.CONSOLE_CREDENTIALS_PASSWORD_PFX, envArray);				
    }
    
    private static HttpResponse checkAuth(HttpResponse httpResponse, String envUrl, Environment springEnv) throws Exception {
	HttpResponse response = null;
	if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_UNAUTHORIZED) {
	    logger.info("Response Error ENV: "+envUrl+" | "+httpResponse.getStatusLine().getProtocolVersion()+":"+HttpStatus.SC_UNAUTHORIZED+" "+httpResponse.getStatusLine().getReasonPhrase());		
	    String u = springEnv.getProperty(Constants.CONSOLE_CREDENTIALS_USERNAME_PFX + "default");
	    String p = springEnv.getProperty(Constants.CONSOLE_CREDENTIALS_PASSWORD_PFX + "default");
	    logger.info("Retry to connect with credentials: "+u+"/"+p);
	    response = Utils.getKarafHttpResponse(envUrl, u, p);
	    return response;
	}
	return httpResponse;
    }

}
