package br.com.teste.googlePage;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import br.com.teste.campo.treinamento.DSL;
import junit.framework.Assert;

public class TesteGoogle {
	
	
	@Test
	public void teste() {
		
		//senão colocar o driver no driver do S.O
		//System.setProperty("webdriver.gecko.driver", "C:\adriano\libs\driverBrowserSelenium/geckodriver.exe");
		WebDriver driver =  new FirefoxDriver();
			
		//WebDriver driver =  new InternetExplorerDriver();
		
		//System.setProperty("webdriver.chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromedriver.exe");
		//WebDriver driver =  new ChromeDriver();
		
		//posição do browser
		//driver.manage().window().setPosition(new Point(100, 100));
		
		//tamanho do browser
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//acessa(abre) a pagina do google
		driver.get("http://www.google.com");
		
		DSL dsl = new DSL(driver);
		
		dsl.escreve("lst-ib", "java");
		dsl.clickButtonAtributeName("btnK");
		
		//imprime o titulo da pagina
		//System.out.println(driver.getTitle());
		
		Assert.assertEquals("Google", driver.getTitle());
		
		//fecha o browser(todas as abas)
		//driver.quit();
	}

}
