package com.neopane.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.neopane.listeners.RetryFailedTests;
import com.neopane.pages.OrangeLoginPage;
import com.neopane.utils.DataProviderUtils;

public final class OrangeHomeTest extends BaseTest {

	private OrangeHomeTest () {}
	
	@Test  
	//(dataProvider="getData", dataProviderClass=DataProviderUtils.class, retryAnalyzer=RetryFailedTests.class )
	public void loginlogoutTest(Map<String, String> hmap) {
	      
	   
		 String title = new OrangeLoginPage() 
		                    .enterUsername(hmap.get("username"))
		                    .enterPasswd(hmap.get("password"))
		                    .login()
		                    .clickonWelcome()
		                    .clickLogout()
		                    .getTitle();
		
		    Assertions.assertThat(title)
		              .isEqualTo("OrangeHRM");
                         
	}
	
	
	@Test 
	public void secondTest(Map<String, String> hmap) {
	      
	   
		 String title = new OrangeLoginPage() 
				 		     .enterUsername(hmap.get("username"))
				 		    .enterPasswd(hmap.get("password"))
		                    .login()
		                    .clickonWelcome()
		                    .clickLogout()
		                    .getTitle();
		
		    Assertions.assertThat(title)
		              .isEqualTo("OrangeHRM");
                         
	}
	
	
	
}
