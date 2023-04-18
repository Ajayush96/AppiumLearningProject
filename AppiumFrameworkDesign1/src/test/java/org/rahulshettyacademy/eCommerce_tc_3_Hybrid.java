package org.rahulshettyacademy;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.rahulshettyacademy.TestUtils.BaseTest;
import org.rahulshettyacademy.pageObject.android.*;

    public class eCommerce_tc_3_Hybrid extends BaseTest{
	FormPage formPage;
	@Test(dataProvider="getData")
	public void FillForm(String Name, String Gender, String Country) throws InterruptedException
	{
		formPage = new FormPage(driver);
		formPage.setNameField(Name);
		formPage.setGender(Gender);
		formPage.setCountrySelection(Country);
		ProductCatelogPage productCatelog=formPage.submitForm();
		productCatelog.addItemToCartByIndex(0);
		productCatelog.addItemToCartByIndex(0);
		CartPage cartPage=productCatelog.goToCartPage();

		//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		double totalSum=cartPage.getProductsSum();
		double displayeFormattedSum=cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayeFormattedSum);
		cartPage.acceptTermConditions();
		cartPage.submitOrder();
		
	}
	
//	@BeforeMethod
//	public void preSetup()
//	{
//		formPage.setActivity();
//	}

	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"Ashish Jha","female","Argentina"}};
	}

}
