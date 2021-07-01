package com.automation.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AddAttachment {
	
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
    	//AndroidDriver dr = new AndroidDriver()
    	capabilities.setCapability("BROWSER_NAME", "Android");
    	capabilities.setCapability("VERSION", "10"); 
    	capabilities.setCapability("deviceName","Galaxy S9+");
    	capabilities.setCapability("platformName","Android");
    	capabilities.setCapability("appPackage", "com.samsung.android.messaging");
    	capabilities.setCapability("appActivity","com.samsung.android.messaging.ui.view.main.WithActivity");
    	
    	/*capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
    	capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
    	*/
    	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	WebDriverWait wait = new WebDriverWait(driver, 5);
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
    	
    	//driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
    	
    	driver.findElementById("com.samsung.android.messaging:id/blackbird_first_launch_next_button").click();
    	
    	driver.findElementByXPath("//android.widget.Button[@text='Start']").click();
    	
    	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().content-desc(\"Compose new message\")")).click();
    	
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Contacts\")")).click();
    	
    	//driver.findElementByXPath("//android.widget.TextView[@text='Contacts']").click();
    	
    	//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollIntoView(text(\"Matt\"))"));
    	
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Matt\"))"));
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Matt\")")).click();
    	
    	driver.findElementById("attach_camera_button").click();
    	
    	driver.findElementByXPath("//android.widget.TextView[@text='Take picture']").click();
    	
   Activity activity = new Activity("com.sec.android.app.camera", "com.sec.android.app.camera.Camera");
  
 String activ = driver.currentActivity();
 System.out.println("This is the new Activity --"+activ);
   
   ((AndroidDriver<MobileElement>) driver).startActivity(activity);
    	
    	driver.findElementById("//GLButton[@text='Take picture']").click();
    	
    	driver.findElementById("okay").click();
    	
    	

	}

}
