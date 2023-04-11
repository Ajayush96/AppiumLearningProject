package rahulshettyacademy.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class swipeDemo extends BaseTest{
	
	@Test
	public void ScrollDemoTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[11]"))
		.click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gallery\"));"));
		
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Gallery']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		
		WebElement firstImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
		swipeAction(firstImage,"left");
		Assert.assertEquals(driver.findElement(AppiumBy.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
		
	}

}
