package com.neopane.pages;

import org.openqa.selenium.By;

import com.neopane.enums.WaitStrategy;
import com.neopane.reports.ExtentLogger;

public final class OrangeHomePage extends BasePage {
	
	
    private final By avatar = By.cssSelector("p.oxd-userdropdown-name");
    private final By logoutLink= By.xpath("//a[text()='Logout']");
 
    
    
    public OrangeHomePage clickonWelcome() {
    	
    	click(avatar, WaitStrategy.PRESENCE );
    	ExtentLogger.pass("Clicked Welcome avatar");
       	return this;
    }
    
    public OrangeLoginPage clickLogout() {
    
    	click(logoutLink,WaitStrategy.PRESENCE );
    	ExtentLogger.pass("Clicked on logout button");
    	return new OrangeLoginPage();
    }
    
    
}
//new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(15)) 
//.until(ExpectedConditions.elementToBeClickable(logoutLink));//old

//wait.until(d->d.findElement(logoutLink).isEnabled()); //java8