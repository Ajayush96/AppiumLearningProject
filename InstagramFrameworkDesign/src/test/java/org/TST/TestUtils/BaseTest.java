package org.TST.TestUtils;

import java.io.*;
import java.net.URL;
import java.time.Duration;

import org.TST.pageObject.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.util.*;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	Properties prop;
	@BeforeClass
	public void ConfigureAppium() throws IOException, InterruptedException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//instagram//resources//data.properties");
		prop.load(fis);
		String ipAddress1 =prop.getProperty("ipAddress1");
		String port1 = prop.getProperty("port1");
	    //code to start server
		service=new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).
		withAppiumJS(new File("C:\\Users\\Ashish Jha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
		withIPAddress(ipAddress1).usingPort(Integer.parseInt(port1)).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		//Appium code -> appium server ->> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AshishEmulator");
		options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//Instagram_278.0.0.21.117_Apkpure.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	public void comnLogin(AndroidDriver driver) throws InterruptedException, IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//instagram//resources//data.properties");
		prop.load(fis);
		LoginPage lp = new LoginPage(driver);
		lp.userName(prop.getProperty("userName"));
		Thread.sleep(1000);
		lp.passWord(prop.getProperty("password"));
		lp.login();
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//stop server
		service.stop();	
	}

}
