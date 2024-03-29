package com.neopane.constants;

import com.neopane.enums.ConfigProperties;
import com.neopane.utils.JsonUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String CONFIG_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//config//config.properties";

	private static final String JSONCONFIG_PATH = System.getProperty("user.dir")
			+ "//src//test//resources//config//config2.json";
	
	private static final String EXTENTREPORTFOLDERPATH= System.getProperty("user.dir")+"//extent-test-output/";
	
	private static String extentReportFilePath = "";

	public static String getExtentReportFilePath() {
		if( extentReportFilePath.isEmpty()) {
			extentReportFilePath= createReportPath();
		}
		
		return extentReportFilePath;
	}

	 

	private static String createReportPath() {
		 if(JsonUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			 
			 return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		 }
		 else {
			 return EXTENTREPORTFOLDERPATH+"/index.html";
		 }
	}



	public static String getConfigPath() {

		return CONFIG_PATH;
	}

	public static String getJsonConfigPath() {

		return JSONCONFIG_PATH ;
	}

}
