package br.com.teste.campo.treinamento;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteFramesEJanelas {
	
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
	
	@After
	public void encerrar(){
		//driver.quit();
	}
	
	@Test
	public void deveIntegarirFrames(){
		//identifica um frame
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		
		//pega a msg do alert
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		//fecha o alert
		alert.accept();
		
		//tira o foco do frame e o volta para pagina principal
		driver.switchTo().defaultContent();
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	}

	@Test
	public void deveIntegarirJanelas(){
		//clica no botao para abrir a janela
		driver.findElement(By.id("buttonPopUpEasy")).click();
		//troca o foco para o pouoUp utilizando o atributo name
		driver.switchTo().window("Popup");
		//escreve o textarea da janela que abre
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo?");
		//fecha o poupUp
		driver.close();
		//volta o foco para panela pricipal que não possui titulo
		driver.switchTo().window("");
		//escreve o textarea da janela principal
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
	}
	
	@Test
	public void deveIntegarirJanelasSemTitulo(){
		//clica no botao para abrir a janela
		driver.findElement(By.id("buttonPopUpHard")).click();
		//imprime um identificador da janela atual
		System.out.println(driver.getWindowHandle());
		//imprime os identificadores de todas janelas (lista de janelas existentes)
		System.out.println(driver.getWindowHandles());
		
		//troca o foco para janela que abre
		driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("deu certo?");
		//troca o foco para janela principal
		//driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		//escreve o textarea da janela principal
		//driver.findElement(By.tagName("textarea")).sendKeys("e agora?");
   }
}
