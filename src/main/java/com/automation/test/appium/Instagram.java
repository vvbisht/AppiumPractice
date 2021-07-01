package com.automation.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Instagram {
	
	static AndroidDriver driver;
	static PointOption pointStart, pointEnd;
	static Dimension dimension;
	static int edgeBorder = 10;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
    	//AndroidDriver dr = new AndroidDriver()
    	capabilities.setCapability("BROWSER_NAME", "Android");
    	capabilities.setCapability("VERSION", "10"); 
    	capabilities.setCapability("deviceName","Galaxy S9+");
    	capabilities.setCapability("platformName","Android");
    	capabilities.setCapability("appPackage", "com.instagram.android");
    	capabilities.setCapability("appActivity","com.instagram.mainactivity.MainActivity");
    	capabilities.setCapability("autoGrantPermissions", true);
    	
    	/*capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
    	capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
    	*/
    	AppiumServiceBuilder builder = new AppiumServiceBuilder();
    	builder.withIPAddress("127.0.0.1");
    	builder.usingPort(4723);
    	builder.withCapabilities(capabilities);
    	
    	AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
    	service.start();
    //	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    	

    	driver = new AndroidDriver(service.getUrl(),capabilities);
    	
    //	driver.rotate(ScreenOrientation.LANDSCAPE);
    	
    	dimension = driver.manage().window().getSize();
    	
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	
    	String text = driver.findElementById("facebook_text_switcher").getAttribute("text");

    	System.out.println("Text is ---- "+ text);
    	
    	List<MobileElement> list = driver.findElementsByXPath("//android.widget.TextView");
    	
    	for(int i=0;i<list.size();i++)
    	{
    		MobileElement element = (MobileElement)driver.findElementsByXPath("//android.widget.TextView").get(i);
    		if(element.getAttribute("text").contains("Vivek Bisht"))
    		{
    			element.click();
    			break;
    		}
    	}
    	
    	String firstPostText = driver.findElementById("row_feed_photo_profile_name").getAttribute("text");
    	
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"ghantaa\"))"));
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"ghantaa\")"));
    	
    	MobileElement element = (MobileElement) driver.findElementById("row_feed_photo_media_tag_hints");
    	
    	tap(dimension);
    	
    	System.out.println("First post is from --- "+ firstPostText);
    	
    	pointStart = PointOption.point(dimension.width/2,dimension.height/2);
    	
    	System.out.println(driver.currentActivity() + " --------is current activity");
    	
    	driver.findElementById("row_feed_button_share").click();
    	
    	service.stop();
    	
    	//swipeRight(dimension);
    	//swipeUp(dimension);
    	
    	//swipeUp(dimension);
    	
    	//swipeUp(dimension);
    	
    	//swipeUp(dimension);
    	
    	System.out.println(driver.currentActivity() + " --------is current activity");
    	
    	
    	//driver.findElementByXPath("//android.widget.Button[@content-desc='Shutter']").click();
    	
    	
    	//driver.findElementById("permission_allow_button").click();
    	
    	//driver.findElementByXPath("//android.widget.Button[@content-desc='Shutter']").click();
    	
    	//driver.findElementByXPath("//android.view.ViewGroup").click();
    	
    	/*driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Aman Sharma\"))"));

    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Aman Sharma\")")).click();
    	*/
    	
    	//driver.findElementById("facebook_text_switcher").click();

    	
	}
	
	public static void tap(Dimension dem)
	{
		//TouchActions action = new TouchActions(driver);
		TouchAction actions = new TouchAction(driver);
		
		actions.tap(PointOption.point(dem.width/2,dem.height/2)).perform();
		actions.tap(PointOption.point(dem.width/2,dem.height/2)).perform();
		
		//actions.perform();
		
		//elemen
		//action.doubleTap(element);
		//action.perform();
	}
	
	public static void swipeLeft(Dimension dim)
	{
		pointEnd = PointOption.point(edgeBorder, dim.height/2);
		TouchAction action = new TouchAction(driver);
		action.press(pointStart).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(pointEnd).release().perform();
		//return pointEnd;
		
	}
	
	public static void swipeRight(Dimension dim)
	{
		
		pointEnd = PointOption.point(dim.width-edgeBorder, dim.height/2);
		TouchAction action = new TouchAction(driver);
		action.press(pointStart).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(pointEnd).release().perform();
		
	}
	
	public static void swipeUp(Dimension dim)
	{
		
		pointEnd = PointOption.point(dim.width/2, edgeBorder);
		TouchAction action = new TouchAction(driver);
		action.press(pointStart).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(pointEnd).release().perform();
		
	}
	
	public static void swipeDown(Dimension dim)
	{
		pointEnd=PointOption.point(dim.width/2,dim.height-edgeBorder);
				TouchAction action = new TouchAction(driver);
		action.press(pointStart).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(pointEnd).release().perform();
		
	}
	

}
