package com.neopane.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neopane.driver.DriverManager;
import com.neopane.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {}
	
	
	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
		
		WebElement element= null;
		
		if(waitStrategy==WaitStrategy.CLICKABLE) {
			
			element=	new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15)) 
	    	.until(ExpectedConditions.elementToBeClickable(by));
		} 
		else if(waitStrategy==WaitStrategy.VISIBLE) {
			
			element=	new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15)) 
	    	.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else if(waitStrategy==WaitStrategy.PRESENCE) {
			
			element=	new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15)) 
	    	.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(waitStrategy==WaitStrategy.NONE) {
			
			element= DriverManager.getDriver().findElement(by) ;
		}
		
		return element;
	}
	

}
