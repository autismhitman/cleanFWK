package com.neopane.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.neopane.enums.ConfigProperties;
import com.neopane.utils.JsonUtils;
import com.neopane.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
 
	private Driver() {}
	
	 
	
	public static void initDriver(String browser)  {
		
			
		if(Objects.isNull(DriverManager.getDriver())) {
			
			if(browser.equalsIgnoreCase("chrome")) {
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver(options));
			}
			
			else if(browser.equalsIgnoreCase("ff")) {
				
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
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
