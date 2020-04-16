package br.com.adalbertofjr.appium;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.adalbertofjr.appium.core.DSL;
import br.com.adalbertofjr.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {

	private DSL dsl = new DSL();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		// driver = DriverFactory.getDriver();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar Formulário
		DriverFactory.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}

	@Test
	public void devePreencherCampoNome() throws MalformedURLException {

		// Escrever o nome
		dsl.typeText(MobileBy.AccessibilityId("nome"), "Adalberto");

		// Checar o nome escrito
		Assert.assertEquals("Adalberto", dsl.getText(MobileBy.AccessibilityId("nome")));

	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		// Selecionar Formulário
		// List<MobileElement> findElements =
		// driver.findElements(By.className("android.widget.TextView"));
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		// clicar no combo
		// driver.findElement(MobileBy.AccessibilityId("console")).click();
		dsl.selectSpinner(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// selecionar a opcao clicada
		// driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo
		// Switch']")).click();

		// verificar opcao selecionada
		String chooseElement = dsl.getText(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", chooseElement);

	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

}
