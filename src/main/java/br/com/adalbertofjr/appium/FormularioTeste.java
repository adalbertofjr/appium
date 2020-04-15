package br.com.adalbertofjr.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.adalbertofjr.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {
	
	private static AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar Formulário
		 driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}

	
	@Test
	public void devePreencherCampoNome() throws MalformedURLException {
	    
	    //Escrever o nome
	     MobileElement nomeElement = driver.findElement(MobileBy.AccessibilityId("nome"));
	     nomeElement.sendKeys("Adalberto");
	    

	    //Checar o nome escrito
	     Assert.assertEquals("Adalberto", nomeElement.getText());
	  
	}

	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {
	   
	    //Selecionar Formulário
//	     List<MobileElement> findElements = driver.findElements(By.className("android.widget.TextView"));
	    //driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    //clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	     
	    //selecionar a opcao clicada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();	    
	    
	    //verificar opcao selecionada
	    String chooseElement = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", chooseElement);
	     
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

}
