package com.neopane.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {}
	
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();
	
	
	
	
	public static WebDriver getDriver() {
		return dr.get();
	}


	 static void setDriver(WebDriver dref) {
		 if(Objects.nonNull(dref)) 
			 dr.set(dref);
		 
	}
	
	 static void unload() {
		dr.remove();
	}
}
