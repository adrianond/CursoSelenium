package br.com.teste.alert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.teste.dsl.DSL;

public class TestAlert {
	
	private WebDriver driver = null;
	private DSL dsl = null;
	
	@Before
	public void inicializar(){
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void finalizar(){
		//driver.quit();
	}

	@Test
	public void testeIntegarirComAlertSimples() {
		//clico no botão que vai disparar o alert
		dsl.clickButton("alert");
		
		//pega o evento externo a pagina, ou seja, o alert
		Alert alert = driver.switchTo().alert();
		
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		//fecha o alert, ou seja, clica no OK do alert
		alert.accept();
		dsl.escreve("elementosForm:nome", texto);
	}
}