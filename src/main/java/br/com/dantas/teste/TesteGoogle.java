package br.com.dantas.teste;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.teste.browser.EnumBrowser;
import br.com.teste.core.DSL;
import br.com.teste.core.DriverFactory;


public class TesteGoogle {
	
	
	@Test
	public void teste() {
		
		//senão colocar o driver no driver do S.O
		//System.setProperty("webDriverFactory.getDriver().gecko.driver", "C:\adriano\libs\driverBrowserSelenium/geckoDriverFactory.getDriver().exe");
		//WebDriver driver =  new FirefoxDriver();
			
		//WebDriver driver =  new InternetExplorerDriver();
		
		/*System.setProperty("webDriverFactory.getDriver().chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromeDriverFactory.getDriver().exe");
		WebDriver driver =  new ChromeDriver();*/
		
		
		//posição do browser
		//DriverFactory.getDriver().manage().window().setPosition(new Point(100, 100));
		
		//tamanho do browser
		DriverFactory.getDriver(EnumBrowser.FIREFOX).manage().window().setSize(new Dimension(1200, 765));
		
		//acessa(abre) a pagina do google
		DriverFactory.getDriver().get("http://www.google.com");
		
		DSL dsl = new DSL();
		
		dsl.escreve("lst-ib", "java");
		dsl.clickButtonAtributeName("btnK");
		
		//imprime o titulo da pagina
		System.out.println(DriverFactory.getDriver().getTitle());
		
		Assert.assertEquals("java - Pesquisa Google", DriverFactory.getDriver().getTitle());
		
		//fecha o browser(todas as abas)
		DriverFactory.killDriver();
	}

}
