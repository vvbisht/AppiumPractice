package com.automation.test.appium;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Spotify {
	
	public static AndroidDriver driver;

	public static void main(String[] args) {
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
    	//AndroidDriver dr = new AndroidDriver()
    	capabilities.setCapability("BROWSER_NAME", "Android");
    	capabilities.setCapability("VERSION", "10"); 
    	capabilities.setCapability("deviceName","Galaxy S9+");
    	capabilities.setCapability("platformName","Android");
    	capabilities.setCapability("appPackage", "com.spotify.music");
    	//capabilities.setCapability("appActivity","com.spotify.music.MainActivity");
    	capabilities.setCapability("appActivity","com.spotify.music.features.nowplaying.v2.NowPlayingActivity");
    	
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
    	
    	service.stop();
    	
    	//dimension = driver.manage().window().getSize();

		// TODO Auto-generated method stub

	}

}
