package br.com.teste.validar.campos;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.teste.cadastro.TesteCadastroPage;

public class ValidarCampos {
	
	private WebDriver driver = null;
	TesteCadastroPage page = null;
	
	@Before
	public void inicializa(){
		//System.setProperty("webdriver.chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "C:\\adriano\\libs\\driverBrowserSelenium/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver =  new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new TesteCadastroPage(driver);
	}
	
	@After
	public void encerrar(){
		//driver.quit();
	}

	@Test
	public void deveValidarNomeObrigatorio() {
		boolean flag;
		page.setNome("Adriano");
		String nome = page.obterValorCampoNome();

		if (nome.equals("")) {
			flag = false;
		} else {
			flag = true;
		}
		// TESTE 1
		Assert.assertTrue(flag);

		// TESTE 2 - SEN�O PREENCHER O NOME - TESTE RETORNA TRUE
		page.cadastrar();
		// pega o evento externo a pagina, ou seja, o alert
		Alert alert = page.validarAvisoAlert();
		Assert.assertEquals("Nome eh obrigatorio", alert.getText());
	}

	
	@Test
	public void deveValidarSobreNomeObrigatorio() {
		boolean flag;
		page.setNome("Adriano");
		page.setSobreNome("Dantas");
        String sobreNome = page.obterValorCamposobreNome();
		
		if (sobreNome.equals("")) {
			flag = false;
		} else {
			flag = true;
		}
		// TESTE 1
		// Assert.assertTrue(flag);

		// TESTE 2
		page.cadastrar();
		// pega o evento externo a pagina, ou seja, o alert
		Alert alert = page.validarAvisoAlert();
		Assert.assertEquals("Sobrenome eh obrigatorio", alert.getText());
	}

	@Test
	public void deveValidarSexoObrigatorio() {
		page.setNome("Adriano");
		page.setSobreNome("Dantas");
		page.setSexoMasculino();
		page.setSexoMasculino();
		page.cadastrar();
		
		Alert alert = page.validarAvisoAlert();
		Assert.assertEquals("Sexo eh obrigatorio", alert.getText());
	}

	@Test
	public void deveValidarComidaFavoritaO() {
		boolean flag;
		page.setNome("Adriano");
		page.setSobreNome("Dantas");
		page.setSexoMasculino();
		page.setComidaFrango();
		page.setVegetariano();
		boolean frangoIsSelected = page.isComidaFrangoSelecionado();
		boolean vegetarianoIsSelected = page.isVegetarianoSelecionado();

		// TESTE1
		if (frangoIsSelected && vegetarianoIsSelected) {
			flag = false;
		} else {
			flag = true;
		}
		// Assert.assertTrue(flag);

		// TESTE2
		page.cadastrar();
		Alert alert = page.validarAvisoAlert();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
	}

	//Esporte
	@Test
	public void deveValidarPraticaEsporte() {
		List<String> lista  = new ArrayList<String>();
		lista.add("Corrida");
		lista.add("O que eh esporte?");
		boolean flag = true;
		page.setNome("Adriano");
		page.setSobreNome("Dantas");
		page.setSexoMasculino();
		page.setComidaFrango();
		
		Select combo =  page.recuperarValoresCombo(lista);

		List<WebElement> elementList = combo.getAllSelectedOptions();
		if (elementList.size() > 1) {
			for (WebElement elemento : elementList) {
				String conteudo = elemento.getText();
				if (conteudo.contains("O que eh esporte?")) {
					flag = false;
				}
			}
		}
		
		//TESTE1
		// Assert.assertTrue(flag);
		
		 // TESTE2
		page.cadastrar();
		Alert alert = page.validarAvisoAlert();
		Assert.assertEquals("Voce faz esporte ou nao?", alert.getText());
	}
	
	@Test
	public void escreveDuasVezes(){
		page.escreveLImpaTexto();
	}
}
