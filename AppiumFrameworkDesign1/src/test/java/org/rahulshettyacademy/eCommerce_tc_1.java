package org.rahulshettyacademy;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;


public class eCommerce_tc_1 extends BaseTest{
	
//	@BeforeMethod
//	public void preSetUp()
//	
//	{
//		Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
//        driver.startActivity(activity);
//	}
	
	@Test
	public void FillForm_ErrorValidation() throws InterruptedException
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashish jha");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//toast message verification
		String toastMessage=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("Name");
		System.out.println(toastMessage);
		Assert.assertEquals(toastMessage, "Please  your name");	
		
	}
	
	@Test
	public void FillForm_positiveFlow() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Ashish jha");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.Toast)[1]")).size()<1);
			
		
	}

}
