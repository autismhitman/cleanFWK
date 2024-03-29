package com.neopane.pages;

import org.openqa.selenium.By;

import com.neopane.driver.DriverManager;
import com.neopane.enums.WaitStrategy;
import com.neopane.reports.ExtentLogger;
import com.neopane.waits.ExplicitWaitFactory;

public class BasePage {
	
	
	protected void click(By by, WaitStrategy  waitStrategy, String element) {
		
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		ExtentLogger.pass( element +" is clicked", true);
		 
	}
	

	
    protected void sendKeys(By by, String value,WaitStrategy  waitStrategy, String element) {
    	
    	ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
    	ExtentLogger.pass( element +" value is entered", true);
	}
    
    protected String getPageTitle() {
		
		return DriverManager.getDriver().getTitle();
	}
}
