package br.com.adalbertofjr.appium;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTest {
	
	private static AndroidDriver driver;
	
	@Test
	public void deveSomarDoisMaisDoisERetornarQuatro() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

	    URL remoteUrl = new URL("http://localhost:4723/wd/hub");
	    
	    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	    
	    MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("plus");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
	    el5.click();
	    MobileElement el6 = (MobileElement) driver.findElementByAccessibilityId("equals");
	    el6.click();
	    MobileElement el7 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
	    el7.click();
	    
	    Assert.assertEquals("4", el7.getText());
	    
	    driver.quit();
	}

}
