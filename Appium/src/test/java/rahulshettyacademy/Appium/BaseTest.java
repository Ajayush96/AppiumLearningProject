package rahulshettyacademy.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.rahulshettyacademy.pageObject.android.FormPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException
	{
	////code to start server
		service=new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe")).
		withAppiumJS(new File("C:\\Users\\Ashish Jha\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).
		withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		service.start();
		//AndroidDriver, IosDriver
		//Appium code -> appium server ->> Mobile
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("AshishEmulator");
		//set chromeExecutable for browser automation
		//options.setChromedriverExecutable("C:\\Users\\Ashish\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//API Demos_4.0_apkcombo.com.apk");
		options.setApp(System.getProperty("user.dir")+"//src//test//java//resources//General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
//	public void LongPressAction(WebElement ele)
//	{
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",3000));
//	}
//	public void scrollToEndAction()
//	{
//		
//		boolean canScrollMore;
//		do {
//		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
//			    "left", 100, "top", 100, "width", 200, "height", 200,
//			    "direction", "down",
//			    "percent", 3.0
//			));
//		}
//		while(canScrollMore);
//	}
//	public void swipeAction(WebElement ele,String direction)
//	{
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
//			    "direction", direction,
//			    "percent", 0.75
//			));
//	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//stop server
		service.stop();	
	}

}
