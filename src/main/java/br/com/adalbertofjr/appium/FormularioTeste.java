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

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {
	
	private static AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/adalbertofernandesjunior/eclipse-workspace/CursoAppium/src/main/resources/ct_appium.apk" );
		
		
		URL remoteUrl = new URL("http://localhost:4723/wd/hub");
		
		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@Test
	public void devePreencherCampoNome() throws MalformedURLException {
	    
	    //Selecionar Formulário
	     List<MobileElement> findElements = driver.findElements(By.className("android.widget.TextView"));
	    
	     findElements.get(1).click();
	   
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
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
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
		driver.quit();
	}

}
