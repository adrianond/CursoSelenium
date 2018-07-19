package br.com.teste.frames.janelas;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.teste.dsl.DSL;


public class TesteFramesEJanelas {
	
	WebDriver driver = null;
	DSL dsl = null;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", "C:\\adriano\\libs\\driverBrowserSelenium/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void encerrar(){
		driver.quit();
	}
	
	@Test
	public void deveIntegarirFrames(){
		//identifica um frame
		dsl.recuperarFrame("frame1");
		//clica no botao do frame aberto para disparar um alert
		dsl.clickButton("frameButton");
		
		//muda o foco para o botao do alert
		Alert alert = dsl.clickBotaoAlert();
		//pega a msg do alert
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		//fecha o alert
		alert.accept();
		
		//tira o foco do frame e o volta para pagina principal
		dsl.retiraFocoFrame();
		dsl.escreve("elementosForm:nome", msg);
	}

	@Test
	public void deveIntegarirJanelas(){
		//clica no botao para abrir a janela
		dsl.clickButton("buttonPopUpEasy");
		//troca o foco para o pouoUp utilizando o atributo name
		dsl.inserirFocoPoupup("Popup");
		//escreve o textarea da janela que abre
		dsl.escreve(By.tagName("textarea"), "deu certo?");
		
		//fecha o poupUp
		driver.close();
		//volta o foco para panela principal que não possui titulo
	    driver.switchTo().window("");
		//escreve o textarea da janela principal
		dsl.escreve(By.tagName("textarea"), "e agora?");
	}
	
	@Test
	public void deveIntegarirJanelasSemTitulo(){
		//clica no botao para abrir a janela
		dsl.clickButton("buttonPopUpHard");
		//imprime um identificador da janela atual
		System.out.println(driver.getWindowHandle());
		//imprime os identificadores de todas janelas (lista de janelas existentes)
		System.out.println(driver.getWindowHandles());
		
		//troca o foco para janela que abre
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		dsl.escreve(By.tagName("textarea"), "deu certo?");
		
		//fecha o poupUp
		driver.close();
		
		//troca o foco para janela principal
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		//escreve o textarea da janela principal
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
   }
	
	@Test
	public void deveIntegarirComFrameEscondido() {
		// pega o elemento : frame
		WebElement frame = dsl.getElementById("frame2");
		// realiza o scroll na tela:O primeiro parametro (0) é o eixo 'X' = horizontal,
		//o segundo parametro é o um argumento para o eixo y = vertical
		// isso para não passar o valor do eixo 'Y' fixo, logo eixo 'Y' =
		// frame.getLocation().y
		dsl.executarJS("window.scrollBy(0, arguments[0])", frame.getLocation().y);
		dsl.recuperarFrame("frame2");
		dsl.clickButton("frameButton");
		//coloca foco no botao alert
		Alert alert = dsl.clickBotaoAlert();
		//pega a msg do alert
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
	}
}
