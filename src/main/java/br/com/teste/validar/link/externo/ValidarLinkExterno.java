package br.com.teste.validar.link.externo;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.teste.core.DSL;
import br.com.teste.core.DriverFactory;

public class ValidarLinkExterno {
	
	private DSL dsl = null;
	
	@Before
	public void inicializar(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/validarLinkExterno.html");
		dsl = new DSL();
	}
	
	@Test
	public void testeIntegarircomLinks() throws InterruptedException {
		
		// Armazenar o identificador de janela atual
		String winHandleBefore = DriverFactory.getDriver().getWindowHandle();
		
		dsl.clicarLink("linkExterno");
		
		/*WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));
		
		SignIn_click(driver);*/
		   
		Thread.sleep(5000);
		    		
		//troca o foco para janela que abre
		for(String winHandle : DriverFactory.getDriver().getWindowHandles()){
		    DriverFactory.getDriver().switchTo().window(winHandle);
		}
		
		//DriverFactory.getDriver().switchTo().window((String)DriverFactory.getDriver().getWindowHandles().toArray()[0]);
		dsl.escreve("lst-ib", "java");
		//DriverFactory.getDriver().findElement(By.xpath("//input[@name='btnK']")).click();
		//dsl.recuperarBotao2("input", "name", "btnK");
		//dsl.recuperarBotao("input", "name", "btnK");
		dsl.recuperarButton("input", "name", "btnK");
		//dsl.clickButtonAtributeName("btnK");
		
		// Feche a nova janela, se essa janela não for mais necessária
		//DriverFactory.getDriver().close();
		
		// Voltar ao navegador original (primeira janela)
		//DriverFactory.getDriver().switchTo().window(winHandleBefore);
	}

	public WebElement SignIn_click(WebDriver driver) throws InterruptedException {
		WebElement element = null;
		element = DriverFactory.getDriver().findElement(By.xpath("//input[@name='btnK']"));
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
