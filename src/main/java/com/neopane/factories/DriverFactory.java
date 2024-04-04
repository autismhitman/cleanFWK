package com.neopane.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.neopane.driver.DriverManager;
import com.neopane.enums.ConfigProperties;
import com.neopane.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver = null;

		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {

			if (runmode.equalsIgnoreCase("remote")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("chrome");
				driver= new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);

			} else {

				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(options);

				// if working in proxy set up then
				// WebDriverManager.chromedriver().proxy("http://username:password@company.co:portno").setup();

			}

		} else if (browser.equalsIgnoreCase("ff")) {

			if (runmode.equalsIgnoreCase("remote")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName("ff");
				driver= new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), cap);

			} else {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		}

		return driver;
	}

}
