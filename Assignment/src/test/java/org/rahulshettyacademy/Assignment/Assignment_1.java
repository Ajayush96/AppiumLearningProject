package org.rahulshettyacademy.Assignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import org.rahulshettyacademy.pageFactory.*;

public class Assignment_1 extends BaseTest{
	
	@Test
	public void alertClass() throws InterruptedException
	{
		
		//driver.findElement(AppiumBy.id("android:id/button1")).click();
		AlertClass aleartClass = new AlertClass(driver);
		aleartClass.App();
		driver.findElement(By.xpath("//android.widget.TextView[@text='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Alert Dialogs']")).click();
		driver.findElement(By.id("com.hmh.api:id/two_buttons2")).click();
		driver.findElement(By.id("android:id/button2")).click();
		driver.findElement(By.id("com.hmh.api:id/radio_button")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.hmh.api:id/text_entry_button")).click();
		driver.findElement(By.id("com.hmh.api:id/username_edit")).sendKeys("Ashish Jha");
		driver.findElement(By.id("com.hmh.api:id/password_edit")).sendKeys("Test@123");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.hmh.api:id/two_buttons_old_school")).click();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.hmh.api:id/checkbox_button2")).click();
		String Aleart=driver.findElement(By.id("android:id/alertTitle")).getText();
		System.out.println(Aleart);
		Assert.assertEquals(Aleart, "Send Call to VoiceMail");
	}
	
	

}
