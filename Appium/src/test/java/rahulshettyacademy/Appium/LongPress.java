package rahulshettyacademy.Appium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest {
	
	@Test
	public void LogPressGesture() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[11]"))
		.click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[1]"))
		.click();
		WebElement ele=driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
		LongPressAction(ele);
		String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
		System.out.println(menuText);
		Assert.assertEquals(menuText, "Sample menu");
		Assert.assertTrue(driver.findElement(AppiumBy.id("android:id/title")).isDisplayed());
	}

}
