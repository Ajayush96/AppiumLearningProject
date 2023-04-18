package org.rahulshettyacademy.TestUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Listeners extends BaseTest implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReporterObject();
	AppiumDriver driver;
	
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Passed");

	}
    
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		//screenshotPart
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		}catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		extent.flush();

	}

	@Override
	public void onStart(ITestContext arg0) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

	}

}
