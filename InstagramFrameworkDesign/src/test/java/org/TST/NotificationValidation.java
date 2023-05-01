package org.TST;

import java.io.IOException;

import org.TST.TestUtils.BaseTest;
import org.TST.pageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class NotificationValidation extends BaseTest{
	
	@Test
	public void NotificationVal() throws InterruptedException, IOException
	{
		comnLogin(driver);
		
		notificationValidation nV = new notificationValidation(driver);
		nV.heartIcon();
//	    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Gudiya Jha Jha, #mala and others shared 26 photos. 9w\"));"));
//		System.out.println(nV.textValidation());
//		Assert.assertEquals(nV.textValidation(), "Gudiya Jha Jha, #mala and others shared 26 photos. 9w");
		nV.backButton();
		nV.profileIcon();
		nV.savePhoto();
	}

}
