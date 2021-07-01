package com.automation.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SendMessageUsingPOM {
	
	static AndroidDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		
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
	builder.withIPAddress("127.0.0.1");
	builder.usingPort(4723);
	builder.withCapabilities(capabilities);
	
	AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
	service.start();
	
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	WebDriverWait wait = new WebDriverWait(driver, 5);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	/*driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
	
	//driver.findElementByXPath("//android.widget.Button[@text='Next']").click();
	
	driver.findElementById("com.samsung.android.messaging:id/blackbird_first_launch_next_button").click();
	
	driver.findElementByXPath("//android.widget.Button[@text='Start']").click();*/
	
	PageObject object = new PageObject(driver);
	object.enterHomeScreen();
	
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().content-desc(\"Compose new message\")")).click();
	
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Contacts\")")).click();
	
	//driver.findElementByXPath("//android.widget.TextView[@text='Contacts']").click();
	
	//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList().scrollIntoView(text(\"Don\"))"));
	
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Don\"))"));
	
	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Don\")")).click();
	
	driver.findElementById("com.samsung.android.messaging:id/message_edit_text").sendKeys("hello Don");
	
	driver.findElementById("com.samsung.android.messaging:id/send_button1").click();
	
	Thread.sleep(5000);
	
List<MobileElement> elements = driver.findElementsById("com.samsung.android.messaging:id/content_text_view");

for(int i=0;i<elements.size();i++)
{
MobileElement text =(MobileElement) driver.findElementsById("com.samsung.android.messaging:id/content_text_view").get(i);
String check = text.getAttribute("text");
System.out.println("Value of String is -- "+ check);

if(check.contains("hello Don"))
{
	System.out.println("Text was found here");
	break;
}
}
service.stop();

System.out.println("Ending the test case here");
}
	

}
