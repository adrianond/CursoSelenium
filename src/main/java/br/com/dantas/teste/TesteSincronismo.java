package br.com.dantas.teste;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.teste.core.BaseTest;
import br.com.teste.core.DSL;
import br.com.teste.core.DriverFactory;

public class TesteSincronismo extends BaseTest {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}
	
	
	@Test
	public void deveUtilizarEsperaFixa() throws InterruptedException{
		dsl.clicarBotao("buttonDelay");
		//espera fixa
		Thread.sleep(5000);
		dsl.escrever("novoCampo", "Deu certo?");
	}
	
	@Test
	public void deveUtilizarEsperaImplicita() throws InterruptedException{
		//espera implicita - espera at� o tempo desejado pelo elemento, se elemento aparecer antes cancela a espera, sen�o gera erro
		//esta espera n�o funciona apenas para este m�todo esim para todo script, ent�o pode ser colocado no m�todo before();
		//n�o faremos isso, pois estamos testando outras formas de espera, ent�o vamos 'desligar' essa espera no fim deste m�todo
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		dsl.clicarBotao("buttonDelay");
		dsl.escrever("novoCampo", "Deu certo?");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
	
	@Test
	public void deveUtilizarEsperaExplicita() throws InterruptedException{ 
		driver = DriverFactory.getDriver();
		dsl.clicarBotao("buttonDelay");
		//espera implicita - espera at� o tempo desejado pelo elemento, se elemento aparecer antes cancela a espera, sen�o gera erro
		//esta espera  funciona apenas para este m�todo diferente da espera implicita
		WebDriverWait esperaExplicita = new WebDriverWait(driver, 30);
		esperaExplicita.until(ExpectedConditions.presenceOfElementLocated(By.id("novoCampo")));
		dsl.escrever("novoCampo", "Deu certo?");
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
}
