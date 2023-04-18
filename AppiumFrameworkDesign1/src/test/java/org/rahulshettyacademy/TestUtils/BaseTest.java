package org.rahulshettyacademy.TestUtils;

import java.io.*;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.util.*;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//rahulshettyacademy//resources//data.properties");
		prop.load(fis);
		String ipAddress1 =prop.getProperty("ipAddress1");
		String port1 = prop.getProperty("port1");
	    //code to start server
		service=new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).
		withAppiumJS(new File("C:\\Users\\Ashish Jha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
		withIPAddress(ipAddress1).usingPort(Integer.parseInt(port1)).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		//AndroidDriver, IosDriver
		//Appium code -> appium server ->> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(prop.getProperty("AndroidDeviceName"));
		//set chromeExecutable for browser automation
		//options.setChromedriverExecutable("C:\\Users\\Ashish\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//API Demos_4.0_apkcombo.com.apk");
		options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void LongPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",3000));
	}
	public String getScreenshotPath(String testCaseName,AppiumDriver driver) throws IOException
	{
		File source=driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1.capture and place in folder //2.extent report pick file and attach to report
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//stop server
		service.stop();	
	}

}
