package org.TST.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class notificationValidation {
	AndroidDriver driver;
	public notificationValidation(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Activity\"]/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ImageView")
	private WebElement heartIcon;
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Gudiya Jha Jha, #mala and others shared 26 photos. February 16\"]")
	private WebElement textValidation;
	@AndroidFindBy(id="com.instagram.android:id/action_bar_button_back")
	private WebElement backButton;
	@AndroidFindBy(id="com.instagram.android:id/tab_avatar")
	private WebElement profileIcon;
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Photo by Aashish Jha at Row 1, Column 1\"]")
	private WebElement photoClick;
	@AndroidFindBy(id="com.instagram.android:id/row_feed_button_save")
	private WebElement saveButton;
	
	public void heartIcon()
	{
		heartIcon.click();
	}
	public String textValidation()
	{
		String notifiText=textValidation.getText();
		return notifiText;
	}
	public void backButton()
	{
		backButton.click();
	}
	public void profileIcon()
	{
		profileIcon.click();
	}
	public void savePhoto()
	{
		photoClick.click();
		saveButton.click();
	}

}
