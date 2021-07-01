package com.automation.test.appium;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObject {
	
	public PageObject(AndroidDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Next']")
	MobileElement firstNext;
	
	@AndroidFindBy(id="blackbird_first_launch_next_button")
	MobileElement seocondNext;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Start']")
	MobileElement startButton;
	
	
	public void enterHomeScreen()
	{
		firstNext.click();
		seocondNext.click();
		startButton.click();
	}

}
