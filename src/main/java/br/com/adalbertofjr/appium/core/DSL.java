package br.com.adalbertofjr.appium.core;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class DSL {

	public void typeText(By by, String texto) {
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}

	public String getText(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}

	public void selectSpinner(By by, String text) {
		DriverFactory.getDriver().findElement(by).click();
		clickByText(text);
	}

	public void clickByText(String text) {
		DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + text + "']")).click();
	}

}
