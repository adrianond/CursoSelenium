package br.com.teste.xpath;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioTeste {
	
	private DesafioTestePage page = null;
	private WebDriver driver = null;
	
	@Before
	public void iniciarCasoTeste(){
		System.setProperty("webdriver.chrome.driver", "C:\\adriano\\libs\\driverBrowserSelenium/chromedriver.exe");
		driver =  new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new DesafioTestePage(driver);
	}
	
	@After
	public void encerraCasoTeste(){
		
	}
	
	@Test
	public void executarCasoTeste(){
		escreverNome();
		selecionarRadioFeminino();
		selecionarComidaPizza();
		getUsuarioBTabelaSemHeader();
		clicarBotaoLinhaMaria();
		clicarRadioLinhaDoutorado();
		escreverInputLinhaSuperior();
	}
	
	private void escreverInputLinhaSuperior() {
		//há 2 Superior na coluna 2
		//colocar a expressão entre parenteses - (//*[@id='elementosForm:tableUsuarios']//td[2][.='Superior'])traz a resposta para mesmo nivel
		page.setInputLinhaSuperior("(//*[@id='elementosForm:tableUsuarios']//td[2][.='Superior'])[2]/..//input[@type='text']", "Superior");
	}
	
	private void clicarRadioLinhaDoutorado() {
		//*[@id='elementosForm:tableUsuarios']//td[1][.='Doutorado'] - coluna 1 com texto Doutorado
		// ..//td[2][.='Doutorado'] - coluna 2 com texto Doutorado
		page.clicarRadioLinhaDoutorado("//*[@id='elementosForm:tableUsuarios']//td[1][.='Doutorado']/..//td[2][.='Doutorado']/..//input[@type='radio']");
	}

	private void clicarBotaoLinhaMaria() {
		page.clicarBotaoLinhaMaria("//*[@id='elementosForm:tableUsuarios']//td[.='Maria']/..//input[@type='button']");
		//pega o evento externo a pagina, ou seja, o alert e fecha o alert, ou seja, clica no OK do alert
		page.clicarBotaoAlert();
	}

	private void getUsuarioBTabelaSemHeader() {
		String usuario = page.getUsuarioBTabelaSemHeader("//*[@id='tabelaSemJSF']//td[.='Usuario B']");
		Assert.assertEquals("Usuario B", usuario);
	}

	private void selecionarComidaPizza() {
		//volta 1 nivel para selecionar o label
		//page.getComidaPizza("//input[@id='elementosForm:comidaFavorita:2']/../label");
		page.getComidaPizza("//input[@id='elementosForm:comidaFavorita:2']/following-sibling::label");
	}

	private void selecionarRadioFeminino() {
		page.getSexoFeminino("//input[@name='elementosForm:sexo' and @value='F']");
	}

	private void escreverNome() {
		page.setNome("//input[@id='elementosForm:nome']", "Adriano");
	}

}
