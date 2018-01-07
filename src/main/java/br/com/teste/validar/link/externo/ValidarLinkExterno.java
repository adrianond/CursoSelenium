package br.com.teste.validar.link.externo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.teste.campo.treinamento.DSL;

public class ValidarLinkExterno {
	
	private WebDriver driver = null;
	private DSL dsl = null;
	
	@Before
	public void inicializar(){
		driver = new FirefoxDriver();
		//driver =  new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		//System.getProperty("user.dir") - retorna a raiz do projeto
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/validarLinkExterno.html");
		dsl = new DSL(driver);
	}
	
	@Test
	public void testeIntegarircomLinks() throws InterruptedException {
		
		// Armazenar o identificador de janela atual
		String winHandleBefore = driver.getWindowHandle();
		
		dsl.clicarLink("linkExterno");
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));
		
		SignIn_click(driver);*/
		   
		Thread.sleep(5000);
		    		
		//troca o foco para janela que abre
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		
		//driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		dsl.escreve("lst-ib", "java");
		//driver.findElement(By.xpath("//input[@name='btnK']")).click();
		dsl.recuperarBotao2("input", "name", "btnK");
		//dsl.recuperarBotao("input", "name", "btnK");
		//dsl.recuperarButton("input", "name", "btnK").click();
		//dsl.clickButtonAtributeName("btnK");
		
		// Feche a nova janela, se essa janela não for mais necessária
		//driver.close();
		
		// Voltar ao navegador original (primeira janela)
		//driver.switchTo().window(winHandleBefore);
	}

	public WebElement SignIn_click(WebDriver driver) throws InterruptedException {
		WebElement element = null;
		element = driver.findElement(By.xpath("//input[@name='btnK']"));
		while (!isDisplayed(element)) {
			Thread.sleep(3000);
			System.out.println("Element is not visible yet");
		}
		return element;
	}

   public  boolean isDisplayed(WebElement element) {
    try {
        if(element.isDisplayed())
            return element.isDisplayed();
        }catch (NoSuchElementException ex) {
        return false;
    }
    return false;
}


}
