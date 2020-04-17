package br.com.adalbertofjr.appium.core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver driver;

	public static AndroidDriver getDriver() {
		if (driver == null) {
			startAppium();
		}

		return driver;
	}

	private static void startAppium() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"/Users/adalbertofernandesjunior/eclipse-workspace/CursoAppium/src/main/resources/ct_appium.apk");

		URL remoteUrl;
		try {
			remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AndroidDriver(remoteUrl, desiredCapabilities);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
