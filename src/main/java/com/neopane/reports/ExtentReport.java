package com.neopane.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.neopane.constants.FrameworkConstants;
import com.neopane.enums.CategoryType;

public final class ExtentReport {

	private static ExtentReports extent;

	private ExtentReport() {
	}

	public static void initReports() {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter sparks = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			sparks.config().setDocumentTitle("POM Freamwork");
			sparks.config().setTheme(Theme.STANDARD);
			sparks.config().setReportName("Regression Tests");
			extent.attachReporter(sparks);
		}
	}

	public static void closeReports()  {
		if (Objects.nonNull(extent)) {
			extent.flush();

		}
		ExtentManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
		 
			e.printStackTrace();
		}

	}

	public static void createTest(String testName) {
		ExtentManager.setExtTest(extent.createTest(testName));
	}

	public static void addAuthor(String[] authors) {

		for (String author : authors) {
			ExtentManager.getExtTest().assignAuthor(author);
		}
	}

	public static void addCategory(CategoryType[] category) {

		for (CategoryType cat : category) {
			ExtentManager.getExtTest().assignCategory(cat.toString());
		}
	}
}
