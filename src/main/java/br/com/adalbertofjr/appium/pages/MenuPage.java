package br.com.adalbertofjr.appium.pages;

import org.openqa.selenium.By;

import br.com.adalbertofjr.appium.core.DSL;
import br.com.adalbertofjr.appium.core.DriverFactory;

public class MenuPage {

	private DSL dsl = new DSL();

	public void acessarFormulario() {
		// DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		dsl.clicarPorTexto("Formulário");
	}
}
