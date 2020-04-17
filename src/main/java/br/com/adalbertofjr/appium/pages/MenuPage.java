package br.com.adalbertofjr.appium.pages;

import br.com.adalbertofjr.appium.core.BasePages;

public class MenuPage extends BasePages {

	public void acessarFormulario() {
		// DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		clicarPorTexto("Formulário");
	}
}
