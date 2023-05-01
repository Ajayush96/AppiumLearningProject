package org.TST.pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileValidation {
	
	AndroidDriver driver;
	public ProfileValidation(AndroidDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.instagram.android:id/tab_avatar")
	private WebElement profileIcon;
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.Button[1]/android.widget.FrameLayout/android.widget.Button")
    private WebElement editProfile;
	@AndroidFindBy(id="com.instagram.android:id/negative_button")
	private WebElement avtarPopUp;
    @AndroidFindBy(className="android.widget.EditText")
    private List<WebElement> Bio;
    @AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Done\"]/android.widget.ImageView")
    private WebElement saveBio;
    
    
    public void profileIcon()
    {
    	profileIcon.click();
    }
    public void editProfile()
    {
    	editProfile.click();
    }
    public void AvtarPopUp()
    {
    	avtarPopUp.click();
    }
    public String bioText()
    {
    	String bioDetails=Bio.get(2).getText();
    	return bioDetails;
    }
    public void SaveBio()
    {
    	saveBio.click();
    }

}

