package br.com.adalbertofjr.appium.pages;

import org.openqa.selenium.By;

import br.com.adalbertofjr.appium.core.BasePages;

public class FormularioPage extends BasePages {

	public void escreverNome(By by, String nome) {
		escrever(by, nome);
	}

	public String obterNome(By by) {
		return obterTexto(by);
	}

	public void selecionarConsole(By by, String valor) {
		selectSpinner(by, valor);
	}

}
