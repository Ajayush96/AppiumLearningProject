package org.rahulshettyacademy.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.*;

public class ExtentReportDemo {
	ExtentReports extent;
	@BeforeTest
	public void Config()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//responsible for create html file and configrations
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashish Jha");
	}
	
	@Test
	public void intialDemo()
	{
		 ExtentTest test= extent.createTest("Initial Demo");
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://rahulshettyacademy.com");
		 System.out.println(driver.getTitle());
		 //test.addScreenCaptureFromBase64String(null);
		 driver.close();
		// test.fail("Result do not match");
		 extent.flush();
	}

}
