package br.com.dantas.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import br.com.teste.core.BaseTest;
import br.com.teste.core.DSL;
import br.com.teste.core.DriverFactory;

public class TestePrine extends BaseTest {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 765));
		dsl = new DSL();
	}
	

	@Test
	public void deveInteragirComRadioPrime(){
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl.clicarRadio(By.xpath("//input[@id='j_idt86:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:0"));
		dsl.clicarRadio(By.xpath("//label[.='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt86:console:1"));
	}
	
	@Test
	public void deveInteragirComSelectPrime(){
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");
		dsl.selecionarComboPrime("j_idt86:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt86:console_label"));
	}
}
