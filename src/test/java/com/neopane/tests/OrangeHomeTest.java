package com.neopane.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neopane.pages.OrangeLoginPage;
import com.neopane.reports.ExtentReport;

public final class OrangeHomeTest extends BaseTest {

	private OrangeHomeTest () {}
	
	@Test(dataProvider="loginTestData")
	public void loginlogoutTest(String uname, String pwd) {
	      
	     ExtentReport.createTest("loginlogoutTest");
		 String title = new OrangeLoginPage() 
		                    .enterUsername(uname)
		                    .enterPasswd(pwd)
		                    .login()
		                    .clickonWelcome()
		                    .clickLogout()
		                    .getTitle();
		
		    Assertions.assertThat(title)
		              .isEqualTo("OrangeHRM");
                         
	}
	
	@DataProvider(name="loginTestData", parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"Admin","admin123"},
			{"admin1","Admin1"} 
			 
			
		};
		
	}
}
