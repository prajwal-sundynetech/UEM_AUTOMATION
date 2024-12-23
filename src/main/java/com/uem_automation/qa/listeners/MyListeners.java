package com.uem_automation.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uem_automation.qa.utils.ExtentReporter;
import com.uem_automation.qa.utils.Utilities;

public class MyListeners implements ITestListener {

	ExtentReports extentReport;
	ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		System.out.println("\nExecution of Project Tests Started\n");
		extentReport = ExtentReporter.generateExtentReport();

	}

	@Override
	public void onTestStart(ITestResult result) {
//		testName = result.getName(); // retrives the test method name
		extentTest = extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName() + " Started Executing");
		System.out.println(result.getName() + " Started Executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, result.getName() + " Got Passed ✅\n");
		System.out.println(result.getName() + " Got Passed ✅\n");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		WebDriver driver = null;
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		// take screenshot
		String destinationScreenshotPath = Utilities.captureScreenshot(driver, result.getName());
		
		// attach screenshot to Extent report
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		
		//
		extentTest.log(Status.FAIL, result.getName() + " Got Failed ❌");
		extentTest.log(Status.INFO, result.getThrowable() + "\n");
		System.out.println(result.getName() + " Got Failed ❌");
		System.out.println(result.getThrowable() + "\n");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, result.getName() + " Got Skipped 🟡");
		extentTest.log(Status.INFO, result.getThrowable() + "\n");
		System.out.println(result.getName() + " Got Skipped 🟡");
		System.out.println(result.getThrowable() + "\n");	
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		System.out.println("Finisted Executing Project Tests");
		
		// auto launching the extent report
		String pathOfExtentReport = System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
