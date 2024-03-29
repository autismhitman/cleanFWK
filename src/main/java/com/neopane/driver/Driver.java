package com.neopane.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.neopane.enums.ConfigProperties;
import com.neopane.utils.JsonUtils;
import com.neopane.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
 
	private Driver() {}
	
	 
	
	public static void initDriver()  {
		
			
		if(Objects.isNull(DriverManager.getDriver())) {
		
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			WebDriverManager.chromedriver().setup();
			DriverManager.setDriver(new ChromeDriver(options));
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(JsonUtils.get(ConfigProperties.URL));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			 
		}
		
		
	}
	
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}
   
}
