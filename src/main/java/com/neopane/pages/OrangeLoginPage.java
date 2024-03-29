package com.neopane.pages;

import org.openqa.selenium.By;

import com.neopane.driver.DriverManager;
import com.neopane.enums.WaitStrategy;
import com.neopane.reports.ExtentLogger;
import com.neopane.reports.ExtentManager;
import com.neopane.reports.ExtentReport;

public final class OrangeLoginPage extends BasePage {
	
	
    private final By usernameTextfield = By.xpath("//input[@name='username']");
    private final By passwdTextField = By.xpath("//input[@name='password']"); 
    private final By lgnButton = By.xpath("//button[@type='submit']");
    
    
    public OrangeLoginPage enterUsername(String usernametext) {
    	 
    	sendKeys(usernameTextfield, usernametext, WaitStrategy.VISIBLE);
    	ExtentLogger.pass("Entered username");
        return this;
    }
    
    public OrangeLoginPage enterPasswd(String pwdText) {
    	
    	sendKeys(passwdTextField,pwdText, WaitStrategy.VISIBLE);
    	ExtentLogger.pass("Entered password");
        return this;
    }
    
   public OrangeHomePage login() {
    	
    	click(lgnButton,WaitStrategy.PRESENCE ); 
    	ExtentLogger.pass("clicked login button");
    	return new OrangeHomePage();
    }
   
   public String getTitle() {
   	
   	return getPageTitle();
    
   }
}
