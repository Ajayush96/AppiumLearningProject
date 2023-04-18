package org.rahulshettyacademy.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);//responsible for create html file and configrations
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");
		
		extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ashish Jha");
		return extent;
	}

}
