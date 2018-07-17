package br.com.teste.campo.treinamento;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.teste.dsl.DSL;

public class TesteCampoTreinamento {
	
	WebDriver driver = null;
	private DSL dsl = null;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.gecko.driver", "C:\\adriano\\libs\\driverBrowserSelenium/geckodriver.exe");
		driver = new FirefoxDriver();
		//driver =  new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//System.getProperty("user.dir") - retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL(driver);
	}
	
	@After
	public void encerrar(){
		//driver.quit();
	}


	@Test
	public void testeTextField(){
		//pega o elemento input e escreve nele
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	}
	
	@Test
	public void testeTextArea(){
		//pega o elemento textArea e escreve nele
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste Area");
		Assert.assertEquals("Teste Area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
	}
	
	@Test
	public void testeRadioBox(){
		//pega o elemento radio e clica nele
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
	}
	
	//@Test
	public void testeCheckBox(){
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
	}
	
	//@Test
	public void testeCombo(){
	    WebElement element =	driver.findElement(By.id("elementosForm:escolaridade"));
	    Select combo = new Select(element);
	    //combo.deselectByIndex(5);
	    //combo.selectByValue("mestrado");
	    combo.selectByVisibleText("Mestrado");
	    Assert.assertEquals("Mestrado",combo.getFirstSelectedOption().getText());
	}
	
	   @Test
		public void testeVerificaValorCombo(){
		    WebElement element =	driver.findElement(By.id("elementosForm:escolaridade"));
		    Select combo = new Select(element);
		    List<WebElement> elementList = combo.getOptions();
		    Assert.assertEquals(8, elementList.size());
		}
	   
	   @Test
		public void testeVerificaValorComboMultiplo(){
		    WebElement element =	driver.findElement(By.id("elementosForm:esportes"));
		    Select combo = new Select(element);
		    combo.selectByVisibleText("Futebol");
		    combo.selectByVisibleText("Karate");
		    combo.selectByVisibleText("O que eh esporte?");
		    combo.deselectByVisibleText("Karate");
		    List<WebElement> elementList = combo.getAllSelectedOptions();
		    Assert.assertEquals(2, elementList.size());
		}
	   
	   @Test
		public void testeIntegarircomBotoes(){
			WebElement botao =   driver.findElement(By.id("buttonSimple"));
			botao.click();
			Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	   }
	   
	   @Test
		public void testeIntegarircomLinks(){
			driver.findElement(By.linkText("Voltar")).click();
			//Pega o texto da pagina, texto que aparece após clicar no link "Voltar"
			Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
	   }
	   
	   @Test
	   public void deveBuscarTextoNaPagina(){
			/**
			 * Não é a melhor forma, pois corre todo corpo da pagina para pegar o texto especifico
			 */
			//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
			
			/**
			 * Pega o texto especifico contido apenas na tag h3
			 */
			//Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
			
			/**
			 * Pega o texto na tela contido em um elemento que contém a class "facilAchar"
			 */
			String texto = driver.findElement(By.className("facilAchar")).getText();
			Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
			System.out.println(texto);
	   }
	   
	   @Test
	   public void testeJavaScript(){
		   WebElement elemento = dsl.getElementById("elementosForm:nome");
		   dsl.executarJS("arguments[0].style.border = arguments[1]", elemento, "solid 4px red");
	   }
	   
}
