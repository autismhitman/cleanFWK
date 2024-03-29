package com.neopane.tests;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.neopane.driver.DriverManager;

public final class HomeTest extends BaseTest {

	private HomeTest() {}
	
	@Test
	public void test1() {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube",Keys.ENTER);
		
		String title = DriverManager.getDriver().getTitle();
		 assertThat(title)
		          .as("Object is not null").isNotNull()
		          .as("it does not contains the expected test").containsIgnoringCase("google search");
		  
		
		List<WebElement>  elements = DriverManager.getDriver().findElements(By.xpath("//h3")) ;
		//System.out.println(elements.size());
		
		 assertThat(elements)
	          .hasSizeBetween(7, 15)
		     .extracting(WebElement::getText)
		     .contains("Testing Mini Bytes");
		
		 
	}
}
