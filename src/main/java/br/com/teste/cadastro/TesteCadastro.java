package br.com.teste.cadastro;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TesteCadastro {
	
	private WebDriver driver = null;
	private TesteCadastroPage page = null;
	
	@Before
	public void inicializar(){
		driver = new FirefoxDriver();
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
		
		Assert.assertTrue(page.obterNome().contains("adriano"));
	}
}


