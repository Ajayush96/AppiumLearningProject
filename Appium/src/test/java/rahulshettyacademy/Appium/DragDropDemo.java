package rahulshettyacademy.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest{
	
	@Test
	public void DragDropTest() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("android:id/button1")).click();
		driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.TextView[11]"))
		.click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
		
		WebElement source=driver.findElement(By.id("com.hmh.api:id/drag_dot_1"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) source).getId(),
			    "endX", 621,
			    "endY", 560
			));
		
		Thread.sleep(3000);
	}

}
