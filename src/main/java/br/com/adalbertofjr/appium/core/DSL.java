package br.com.adalbertofjr.appium.core;

import static br.com.adalbertofjr.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class DSL {

	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicarPorTexto(String texto) {
		getDriver().findElement(By.xpath("//*[@text='" + texto + "']")).click();
	}

	public void selectSpinner(By by, String text) {
		getDriver().findElement(by).click();
		clicarPorTexto(text);
	}

}
