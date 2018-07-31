package br.com.teste.cadastro;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class TesteCadastro {
	
	private WebDriver driver = null;
	private TesteCadastroPage page = null;
	
	@Before
	public void inicializar(){
		//.setProperty("webdriver.chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromedriver.exe");
		//System.setProperty("webdriver.ie.driver", "C:\\adriano\\libs\\driverBrowserSelenium/IEDriverServer.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\adriano\\libs\\driverBrowserSelenium/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		//driver = new InternetExplorerDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	    page = new TesteCadastroPage(driver);
	}
	
	@Test
	public void executaDesafio(){
		List<String> lista  = new ArrayList<String>();
		lista.add("Superior");
		List<String> listaEsporte  = new ArrayList<String>();
		listaEsporte.add("Corrida");
		
		page.setNome("adriano");	
		page.setSobreNome("Nogueira");
		page.setSexoMasculino();
		page.setComidaFrango();
		page.setEscolaridade(lista);
		page.setEsporte(listaEsporte);
		page.cadastrar();
		
		//Assert.assertTrue(page.obterNome().contains("adriano"));
		Assert.assertEquals("adriano", page.obterNomeByClassPath());
		
	}
}


