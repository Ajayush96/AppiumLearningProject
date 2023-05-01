package org.TST.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FollowerValidation {
	
	AndroidDriver driver;
	public FollowerValidation(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.instagram.android:id/tab_avatar")
	private WebElement profileIcon;
	@AndroidFindBy(id="com.instagram.android:id/row_profile_header_textview_followers_count")
	private WebElement followerCount;
	@AndroidFindBy(id="com.instagram.android:id/row_search_edit_text")
	private WebElement followerSearch;
	@AndroidFindBy(id="com.instagram.android:id/follow_list_username")
	private WebElement username;
	
	public void profileIcon()
	{
		profileIcon.click();	
	}
	public void followerCount()
	{
		followerCount.click();	
	}
	public void followerSearch(String usrName)
	{
		followerSearch.sendKeys(usrName);
	}
	public String userName()
	{
		String userName=username.getText();
		return userName;
	}
}

