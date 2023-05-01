package org.TST;

import java.io.IOException;

import org.TST.TestUtils.BaseTest;
import org.TST.pageObject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class BioValidationTest extends BaseTest{
	
	@Test
	public void BioValidation() throws InterruptedException, IOException
	{
		comnLogin(driver);
		
		ProfileValidation pv = new ProfileValidation(driver);
		pv.profileIcon();
		pv.editProfile();
		pv.AvtarPopUp();
		System.out.println(pv.bioText());
		Assert.assertEquals(pv.bioText(), "WIP");
	}

}
