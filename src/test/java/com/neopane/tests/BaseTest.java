package com.neopane.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.neopane.driver.Driver;
import com.neopane.reports.ExtentReport;

public class BaseTest {
	
    
	protected BaseTest() {}
	
	@BeforeSuite
	protected void setUpReports() {
		
		ExtentReport.initReports();
	}
	 
	@AfterSuite
	protected void tearDownReports() throws IOException {
		
		 
			ExtentReport.closeReports();
		  
	}
	
	@BeforeMethod
	protected void setUp() {
		
        Driver.initDriver();
	}
	
	
	@AfterMethod
	protected void tearDown() {
		
		Driver.quitDriver();
	}

}
