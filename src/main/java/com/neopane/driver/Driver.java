package com.neopane.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.neopane.enums.ConfigProperties;
import com.neopane.exceptions.BrowserInvocationExceptions;
import com.neopane.factories.DriverFactory;
import com.neopane.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Apr 2, 2023
 * 
 * 
 * 
 * 
 */

public final class Driver {
 
	private Driver() {}
	
	 /**
	  * 
	  *  
	  */
	
	public static void initDriver(String browser)  {
		
		
			
		if(Objects.isNull(DriverManager.getDriver())) {
			
			
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			}
			
			catch (MalformedURLException e) {
				
				 throw new BrowserInvocationExceptions("MalformedURL Exception is found");
			}
			
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		}
		
	}
	
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}
   
}
