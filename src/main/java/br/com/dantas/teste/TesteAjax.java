package br.com.dantas.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.teste.core.DSL;
import br.com.teste.core.DriverFactory;

public class TesteAjax {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		DriverFactory.killDriver();
	}

	@Test
	public void testAjax(){
		dsl.escrever("j_idt85:name", "Teste");
		dsl.clicarBotao("j_idt85:j_idt88");
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
//      esperar que o texto no elemento seja igual a 'Teste', lógico que até o tempo limite, 30 seundos			
//		wait.until(ExpectedConditions.textToBe(By.id("j_idt85:display"), "Teste"));
//      espera até que o elemento de ID 'j_idt98 (loading)' saia da tela, lógico que até o tempo limite, 30 seundos		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt85:display"));
	}
}
