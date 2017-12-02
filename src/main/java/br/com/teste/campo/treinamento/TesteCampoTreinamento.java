package br.com.teste.campo.treinamento;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	//@Test
	public void testeTextField(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		//System.getProperty("user.dir") - retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		//pega o elemento input e escreve nele
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
	    //driver.quit();
	}
	
	//@Test
	public void testeTextArea(){
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//pega o elemento textArea e escreve nele
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste Area");
		
		Assert.assertEquals("Teste Area", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		//driver.quit();	
	}
	
	//@Test
	public void testeRadioBox(){
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//pega o elemento radio e clica nele
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
		//driver.quit();	
	}
	
	//@Test
	public void testeCheckBox(){
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
		//driver.quit();	
	}
	
	//@Test
	public void testeCombo(){
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
	    WebElement element =	driver.findElement(By.id("elementosForm:escolaridade"));
	    Select combo = new Select(element);
	    //combo.deselectByIndex(5);
	    //combo.selectByValue("mestrado");
	    combo.selectByVisibleText("Mestrado");
	    Assert.assertEquals("Mestrado",combo.getFirstSelectedOption().getText());
	  //driver.quit();
	    
	}
	
	   @Test
		public void testeVerificaValorCombo(){
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
		    WebElement element =	driver.findElement(By.id("elementosForm:escolaridade"));
		    Select combo = new Select(element);
		    List<WebElement> elementList = combo.getOptions();
		    Assert.assertEquals(8, elementList.size());
		    driver.quit();   
		}
	   
	   @Test
		public void testeVerificaValorComboMultiplo(){
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		    WebElement element =	driver.findElement(By.id("elementosForm:esportes"));
		    Select combo = new Select(element);
		    combo.selectByVisibleText("Futebol");
		    combo.selectByVisibleText("Karate");
		    combo.selectByVisibleText("O que eh esporte?");
		    combo.deselectByVisibleText("Karate");
		    List<WebElement> elementList = combo.getAllSelectedOptions();
		    Assert.assertEquals(2, elementList.size());
		    //driver.quit();   
		}
	   
	   @Test
		public void testeIntegarircomBotoes(){
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			WebElement botao =   driver.findElement(By.id("buttonSimple"));
			botao.click();
			Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
	   }
	   
	   @Test
		public void testeIntegarircomLinks(){
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
			driver.findElement(By.linkText("Voltar")).click();
			
			//Pega o texto da pagina, texto que aparece após clicar no link "Voltar"
			Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
			driver.quit();
			
	   }
	   
	   @Test
	   public void deveBuscarTextoNaPagina(){
			
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			
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
}
