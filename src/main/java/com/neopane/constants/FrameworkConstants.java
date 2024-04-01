package com.neopane.constants;

import com.neopane.enums.ConfigProperties;
import com.neopane.utils.JsonUtils;
import com.neopane.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {
	}
    
	private static final String DIRECTORY_PATH = System.getProperty("user.dir");
	
	private static final String CONFIG_PATH = DIRECTORY_PATH + "//src//test//resources//config//config.properties";

	private static final String JSONCONFIG_PATH =  DIRECTORY_PATH + "//src//test//resources//config//config2.json";
	
	private static final String EXCEL_PATH=  DIRECTORY_PATH + "//src//test//resources//data//Data.xlsx";
	
	private static final String EXTENTREPORTFOLDERPATH= DIRECTORY_PATH +"//extent-test-output/";
	
	private static String extentReportFilePath = "";

	public static String getExtentReportFilePath() {
		if( extentReportFilePath.isEmpty()) {
			extentReportFilePath= createReportPath();
		}
		
		return extentReportFilePath;
	}

	 

	public static String getDirectoryPath() {
		return DIRECTORY_PATH;
	}



	public static String getJsonconfigPath() {
		return JSONCONFIG_PATH;
	}



	public static String getExcelPath() {
		return EXCEL_PATH;
	}



	public static String getExtentreportfolderpath() {
		return EXTENTREPORTFOLDERPATH;
	}



	private static String createReportPath() {
		 if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			 
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
