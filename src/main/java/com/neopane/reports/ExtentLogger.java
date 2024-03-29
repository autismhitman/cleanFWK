package com.neopane.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.neopane.enums.ConfigProperties;
import com.neopane.utils.JsonUtils;
import com.neopane.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {

		ExtentManager.getExtTest().pass(message);
	}

	public static void fail(String message) {

		ExtentManager.getExtTest().fail(message);
	}

	public static void skip(String message) {

		ExtentManager.getExtTest().skip(message);
	}
	
	
	public static void pass(String message, boolean isScreenshotRequired) {

		if(JsonUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired){
										  
			ExtentManager.getExtTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			
		}else {
			
			pass(message);
		}
	}
	
	
	 public static void fail(String message, boolean isScreenshotRequired) {
		 
		 if(JsonUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOT).equalsIgnoreCase("yes") && isScreenshotRequired) {
			                              
			 ExtentManager.getExtTest().fail(message,
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		 }
		 else {
			 
			 fail(message);
		 }
	 }
	 
	 public static void skip(String message, boolean isScreenshotRequired) {
		 
		 if(JsonUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOT ).equalsIgnoreCase("yes") && isScreenshotRequired) {
			                              
			 ExtentManager.getExtTest().skip(message,
					 MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
		 }
		 else {
			 
			 skip(message);
		 }
	 }
}
