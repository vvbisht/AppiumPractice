package com.automation.test.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import junit.framework.Assert;

public class SendMessage 
{
	//static WebDriver driver;
	
	//static AndroidDriver<Android> driver ;
	static AndroidDriver driver;
	
	//static WindowsD
    public static void main( String[] args ) throws MalformedURLException, InterruptedException
    {
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
    	
    	
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Kyle\"))"));
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Kyle\")")).click();
    	
    	driver.findElementById("com.samsung.android.messaging:id/message_edit_text").sendKeys("hello Kyle");
    
    	
    	driver.findElementById("com.samsung.android.messaging:id/send_button1").click();
    	
    	Thread.sleep(5000);
    	
    List<MobileElement> elements = driver.findElementsById("com.samsung.android.messaging:id/content_text_view");
    
for(int i=0;i<elements.size();i++)
{
	MobileElement text =(MobileElement) driver.findElementsById("com.samsung.android.messaging:id/content_text_view").get(i);
    String check = text.getAttribute("text");
    System.out.println("Value of String is -- "+ check);
    
	if(check.contains("hello Kyle"))
	{
		System.out.println("Text was found here");
		break;
	}
}

System.out.println("Ending the test case here");
    	
    	//driver.findElementById("com.samsung.android.messaging:id/fab").click();
    	
    	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Recipient\")")).sendKeys("1234567890");
    
    	
    	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Recipient\")")).sendKeys(Keys.ENTER);
    	
    	//com.samsung.android.messaging:id/message_edit_textiver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Enter message\")")).sendKeys("Hello");
    	
    	/*driver.findElementById("com.samsung.android.messaging:id/message_edit_text").sendKeys("Hello Golu");
    	//iver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().content-desc(\"SIM card 1 Send\")")).sendKeys("Hello");
    	
    	driver.findElementById("com.samsung.android.messaging:id/send_button1").click();

    	
    	List<String> size = driver.findElementsById("com.samsung.android.messaging:id/text_content");
    	
    	for(int i=0;i<size.size();i++)
    	{
    		
    	MobileElement text=	(MobileElement) driver.findElementsById("com.samsung.android.messaging:id/text_content").get(i);
    		
    	if(text.getText().contains("Hello Golu"))
    	{
    		System.out.println("Found Message -- " + text.getText());
    		break;
    	}
    	//	if(driver.findElementById("com.samsung.android.messaging:id/text_content")).get
    		
    	}
    	
    	//driver.findElementById("com.samsung.android.messaging:id/send_button1").click();

    	
    	
   
    	*/
    	
    	//	wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//com.zerodha.kite[@text='Login to Kite']")));
    	/*driver.findElementByXPath("//android.view.View[@content-desc='Login to Kite']").click();
    	//driver.findElementByXPath("//android.widget.EditText[@text='User ID']").click();
    	Thread.sleep(5000);
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"User ID\")")).click();
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"User ID\")")).sendKeys("VR9403");
    	
Thread.sleep(5000);    	
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Password\")")).click();
    	
    	driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Password\")")).sendKeys("vv@vicky93");
    	*///driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"Password\")"));
    	
    	//driver.findElementByXPath("//android.widget.EditText[@text='User ID']").sendKeys("VR9403");
    //	driver.findElementByXPath("android.widget.EditText[@text='Password']").sendKeys("vv@vicky93");
    	//driver.findElementByXPath("android.view.View[@content-desc='LOGIN']").click();
    	
    	//driver.findElementById("(iv_checkbox)[5]");
    	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.flipkart.android:id/ll_select_btn[4]\")"));
    	//WebElement button1 = driver.findElement(ById));
    	//driver.findElement(arg0)
    	/*driver.findElement(By.id("calc_keypad_btn_08"));
    	driver.findElement(By.id("calc_keypad_btn_mul"));
    	driver.findElement(By.id("calc_keypad_btn_08"));*/
    	/*driver.findElement(By.id("calc_keypad_btn_08")).click();
    	driver.findElement(By.id("calc_keypad_btn_mul")).click();
    	driver.findElement(By.id("calc_keypad_btn_05")).click();
    	driver.findElement(By.id("calc_keypad_btn_equal")).click();
    	
    	String text = driver.findElement(By.id("calc_edt_formula")).getText();
    	System.out.println("Result is -- " + text);
    	driver.close();*/
    	//driver.quit();
    	//Thread.sleep(10000);                                        
    	
    	
    }
}
