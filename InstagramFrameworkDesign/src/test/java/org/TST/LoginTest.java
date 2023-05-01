package org.TST;

import java.io.IOException;

import org.TST.TestUtils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.TST.pageObject.*;

public class LoginTest extends BaseTest {

	@Test
	public void loginPage() throws InterruptedException, IOException {
		
		comnLogin(driver);

		FollowerValidation FV = new FollowerValidation(driver);
		FV.profileIcon();
		FV.followerCount();
		FV.followerSearch("syed");
		System.out.println(FV.userName());
		Assert.assertEquals(FV.userName(), "notshayannasir");
	}

}
