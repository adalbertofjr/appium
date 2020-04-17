package br.com.adalbertofjr.appium.test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.adalbertofjr.appium.core.DriverFactory;
import br.com.adalbertofjr.appium.pages.FormularioPage;
import br.com.adalbertofjr.appium.pages.MenuPage;
import io.appium.java_client.MobileBy;

public class FormularioTeste {

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Selecionar Formulário
		menu.acessarFormulario();
	}

	@Test
	public void devePreencherCampoNome() {
		// Escrever o nome
		page.escreverNome(MobileBy.AccessibilityId("nome"), "Adalberto");

		// Checar o nome escrito
		Assert.assertEquals("Adalberto", page.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void deveInteragirCombo() {
		// clicar no combo
		page.selectSpinner(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// verificar opcao selecionada
		Assert.assertEquals("Nintendo Switch",
				page.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView")));
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

}
