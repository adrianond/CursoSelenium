package br.com.dantas.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;

import br.com.teste.core.BaseTest;
import br.com.teste.core.DSL;
import br.com.teste.core.DriverFactory;

public class TestAlert extends BaseTest{
	
	private DSL dsl = null;
	
	@Before
	public void inicializar(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	

	@Test
	public void testeIntegarirComAlertSimples() {
		//clico no botão que vai disparar o alert
		dsl.clickButton("alert");
		
		//pega o evento externo a pagina, ou seja, o alert
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		//fecha o alert, ou seja, clica no OK do alert
		alert.accept();
		dsl.escreve("elementosForm:nome", texto);
	}
}