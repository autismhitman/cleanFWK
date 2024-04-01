package com.neopane.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.neopane.driver.Driver;

public class BaseTest {
	
    
	protected BaseTest() {}
	
	 
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data) {
		
		Map<String, String> hmap = (Map<String, String>) data[0];
        Driver.initDriver(hmap.get("browser"));
	}
	
	
	@AfterMethod
	protected void tearDown() {
		
		Driver.quitDriver();
	}

}
