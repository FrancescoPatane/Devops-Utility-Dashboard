package com.mooney.devops.testing.utility.bundlechecktool.nps.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.core.env.Environment;

import com.google.gson.Gson;
import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.BundleComparison;
import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.Data;
import com.mooney.devops.testing.utility.bundlechecktool.nps.beans.KarafResponse;

public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class.getName());

    private Utils() {
    }

    public static String getBasicAuthHeader(String username, String password) {
	String auth = username + ":" + password;
	byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
	return  "Basic " + new String(encodedAuth);
    }

    public static HttpGet getRequest(String url, String authHeader) {
	HttpGet request = new HttpGet(url);
	request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
	return request;
    }

    public static HttpResponse getResponse(HttpGet request) throws Exception {
	HttpClient client = HttpClients
		.custom()
		.setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())
		.setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
		.build();
	return client.execute(request);
    }

    public static KarafResponse getKarafResponse(String jsonString) {
	return new Gson().fromJson(jsonString, KarafResponse.class);
    }

    public static Map<String, String> getBundleNameVersionMap(List<Data> bundlesList) {
	Map<String, String> bundleNameVersionMap = new HashMap<>();
	for(Data bundle : bundlesList) {
	    if (bundleNameVersionMap.get(bundle.getSymbolicName()) != null) {
		System.out.println("Bundle symbolic name duplicated.");		
		bundleNameVersionMap.put(bundle.getSymbolicName()+" ("+bundle.getName()+")", bundle.getVersion());		
	    }
	    else {
		bundleNameVersionMap.put(bundle.getSymbolicName(), bundle.getVersion());
	    }
	    	    
	}
	
	Map<String, String> newMapSortedByKey = bundleNameVersionMap.entrySet().stream()
                .sorted(Map.Entry.<String,String>comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	
//	Map<String, String> newMapSortedByValue = bundleNameVersionMap.entrySet().stream()
//                .sorted(Map.Entry.<String,String>comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1,e2) -> e1, LinkedHashMap::new));
	
	return newMapSortedByKey;
    }

    public static HttpResponse getKarafHttpResponse(String environmentUrl, String username, String password) throws Exception {
	String authHeader = Utils.getBasicAuthHeader(username, password);
	HttpGet request = Utils.getRequest(environmentUrl, authHeader);
	return Utils.getResponse(request);
    }

    public static Map<String, String> prepareSortedBundleVersionMapStubOn(String jsonString, List<String> bundleToExcludeNames, boolean include) {
	Map<String, String> bundleVersionMap = null;

	if(jsonString != null) {
	    KarafResponse karafResponse = Utils.getKarafResponse(jsonString);
	    List<Data> installedBundles = patternBundlesFromList(karafResponse.getData(), bundleToExcludeNames, include);
	    bundleVersionMap = Utils.getBundleNameVersionMap(installedBundles);
	} else {
	    throw new NullPointerException("JsonString is null!");
	}
	return bundleVersionMap;
    }

    public static Map<String, String> prepareSortedBundleVersionMap(HttpResponse response, List<String> bundlePatternNames, boolean include) throws IOException {
	Map<String, String> bundleVersionMap = null;

	if (response == null) {
	    throw new NullPointerException("Response is null!");
	}

	HttpEntity entity = response.getEntity();

	int code = response.getStatusLine().getStatusCode();
	logger.info("Response Status code: "+code);
	if (code == HttpStatus.SC_OK) {
	    if(entity != null) {
		String jsonString = EntityUtils.toString(entity, "UTF-8");
		KarafResponse karafResponse = Utils.getKarafResponse(jsonString);
		List<Data> installedBundles = patternBundlesFromList(karafResponse.getData(), bundlePatternNames, include);		
		bundleVersionMap = Utils.getBundleNameVersionMap(installedBundles);		
	    } else {
		throw new NullPointerException("Entity is null!");
	    }
	}
	else {
	    throw new NullPointerException("Response Error - "+response.getStatusLine().getProtocolVersion()+":"+code+" "+response.getStatusLine().getReasonPhrase());
	}

	return bundleVersionMap;
    }
    
    private static List<Data> patternBundlesFromList(List<Data> bundleList, List<String> bundlePatternNames, boolean include) {	
	List<Data> bundles = new ArrayList<Data>();
	String[] bundlePatterns = bundlePatternNames.stream().toArray(String[]::new);

	for (Data bundleData : bundleList) {
	    String symName = bundleData.getSymbolicName();
	    if (symName != null && !symName.isEmpty()) {
		symName = symName.trim().toLowerCase();

		if (include) {
		    if (stringContainsItemFromList(symName, bundlePatterns)) {
			bundles.add(bundleData);
		    }
		}
		else {
		    if (!stringContainsItemFromList(symName, bundlePatterns)) {
			bundles.add(bundleData);
		    }
		}
	    }
	}
	if (bundles.isEmpty()) {
	    return new ArrayList<Data>(bundleList);
	}	
	return bundles;
    }

    public static boolean stringContainsItemFromList(String inputStr, String[] items) {
	return Arrays.stream(items).anyMatch(inputStr::contains);
    }
       
    public static List<BundleComparison> getBundleComparisonList(Map<String, String> mainEnvironmentBundles, Map<String, String> environmentToCheckBundles) {
	List<BundleComparison> bundleComparisons = new ArrayList<>();

//	Set<Entry<String, String>> entries = environmentToCheckBundles.entrySet();
//	Map<String, String> copyEnvironmentToCheckBundles = (Map<String, String>) entries.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	
	for(Map.Entry<String, String> entry : mainEnvironmentBundles.entrySet()) {
	    BundleComparison bundleComparison = new BundleComparison();
	    bundleComparison.setMainEnvBundleName(entry.getKey());
	    bundleComparison.setMainEnvBundleVersion(entry.getValue());


	    for(Map.Entry<String, String> entry2 : environmentToCheckBundles.entrySet()) {
		if(entry2.getKey().equals(entry.getKey())) {
		    bundleComparison.setEnvToCheckBundleName(entry2.getKey());
		    bundleComparison.setEnvToCheckBundleVersion(entry2.getValue());
		    break;
		}
	    }

	    bundleComparisons.add(bundleComparison);
	    environmentToCheckBundles.remove(entry.getKey());
	}

	System.out.println("Main bundleComparisons list Size:"+(bundleComparisons != null ? bundleComparisons.size() : 0));
	
	if(!environmentToCheckBundles.isEmpty()) {
	    //System.out.println("List toCheck is NOT empty!");
	    for(Map.Entry<String, String> entry : environmentToCheckBundles.entrySet()) {
		BundleComparison bundleComparison = new BundleComparison();
		bundleComparison.setMainEnvBundleName("");
		bundleComparison.setMainEnvBundleVersion("");
		bundleComparison.setEnvToCheckBundleName(entry.getKey());
		bundleComparison.setEnvToCheckBundleVersion(entry.getValue());
		//System.out.println(">>> "+entry.getKey()+"::"+entry.getValue());
		bundleComparisons.add(bundleComparison);
	    }
	}
	
	System.out.println("Final bundleComparisons list Size:"+(bundleComparisons != null ? bundleComparisons.size() : 0));
	
	return bundleComparisons;
    }

    public static String readFile(String path, Charset encoding) throws IOException {
	byte[] encoded = Files.readAllBytes(Paths.get(path));
	return new String(encoded, encoding);
    }

    public static List<String> getBundleToExcludeNames(Properties bundleToExcludeProp) {
	List<String> bundlesToExcludePropNames = new ArrayList<>(bundleToExcludeProp.stringPropertyNames());
	List<String> bundleToExcludeNames = new ArrayList<>();

	for (String propName : bundlesToExcludePropNames) {
	    bundleToExcludeNames.add(bundleToExcludeProp.getProperty(propName));
	}

	return bundleToExcludeNames;
    }

    public static Properties loadAllProperties (Properties props) {
	logger.info("Loading properties...");
	props = new Properties();        

	try (FileInputStream inputStream = new FileInputStream(Constants.ENV_PROPERTIES)) {
	    props.load(inputStream);
	} catch (IOException e ) {
	    e.printStackTrace();
	}

	try (FileInputStream inputStream = new FileInputStream(Constants.APP_PROPERTIES)) {
	    props.load(inputStream);
	} catch (IOException e ) {
	    e.printStackTrace();
	}

	try (FileInputStream inputStream = new FileInputStream(Constants.ENV_URL_PROPERTIES)) {
	    props.load(inputStream);
	} catch (IOException e ) {
	    e.printStackTrace();
	}

	logger.info("Properties loaded!");
	return props;   
    }

    public static String resolveCreds(Environment springEnv, String prefix, String[] envArray) {
	String componentCreds = "";
	try {
	    componentCreds = springEnv.getProperty(prefix+ envArray[1] + "."+envArray[0]);
	    if (componentCreds == null) {
		componentCreds = springEnv.getProperty(prefix + envArray[1]);
	    }
	} catch (Exception e) {
	    System.out.println("ERROR resolveCreds | "+e.getMessage() + " "+e.getCause());
	    e.printStackTrace();
	}
	return componentCreds;
    }

}
