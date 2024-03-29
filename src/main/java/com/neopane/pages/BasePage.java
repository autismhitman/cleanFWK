package com.neopane.pages;

import org.openqa.selenium.By;

import com.neopane.driver.DriverManager;
import com.neopane.enums.WaitStrategy;
import com.neopane.waits.ExplicitWaitFactory;

public class BasePage {
	
	
	protected void click(By by, WaitStrategy  waitStrategy) {
		
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
	}
	

	
    protected void sendKeys(By by, String value,WaitStrategy  waitStrategy) {
    	
    	ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
	}
    
    protected String getPageTitle() {
		
		return DriverManager.getDriver().getTitle();
	}
}
