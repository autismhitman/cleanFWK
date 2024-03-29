package com.neopane.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class ExtentReport {
	
	private static ExtentReports extent;

	
	
	private ExtentReport() {}
	
	
	public static void initReports() {
		if(Objects.isNull(extent)){
		extent = new ExtentReports();
		ExtentSparkReporter sparks = new ExtentSparkReporter("index.html");
		sparks.config().setDocumentTitle("POM Freamwork");
		sparks.config().setTheme(Theme.STANDARD);
		sparks.config().setReportName("Regression Tests");
		extent.attachReporter(sparks);
		}
	}
	

	public static void closeReports() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
			Desktop.getDesktop().browse(new File("index.html").toURI());
		}
		
	}
	
	public static void createTest(String testName) {
		ExtentManager.setExtTest( extent.createTest(testName));
	}
	 

}
