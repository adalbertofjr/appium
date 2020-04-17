package br.com.adalbertofjr.appium.pages;

import org.openqa.selenium.By;

import br.com.adalbertofjr.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {

	private DSL dsl = new DSL();

	public void escreverNome(By by, String nome) {
		dsl.escrever(by, nome);
	}

	public String obterTexto(By by) {
		return dsl.obterTexto(by);
	}

	public void selectSpinner(By by, String valor) {
		dsl.selectSpinner(by, valor);
	}

}
