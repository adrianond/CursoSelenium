package br.com.teste.xpath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.teste.dsl.DSL;

/**
 * Padr�o PageObject - representa a tela a ser testada
 * @author adriano
 *
 */
public class UsarXpathPage {
	
private DSL dsl;
	
	public UsarXpathPage(WebDriver driver){
		dsl = new DSL(driver);
	}
	
	/**
	 * 
	 * @param nome
	 */
	public String obterTextoElemento(String xPath){
		return dsl.recuperarTextoElementoWithXpath(xPath);
	}
	
	/**
	 * 
	 * @param xPath
	 * @param texto
	 */
	public void setNome(String xPath, String texto){
		dsl.escreveWithXpath(xPath, texto);
	}

	/**
	 * 
	 * @param xPath
	 * @return
	 */
	public String getNome(String xPath) {
	   return dsl.recuperaTextoDigitadoWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 */
	public void clicarBotao(String xPath) {
		dsl.clicarBotaoWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 * @return
	 */
	public String obterValueButton(String xPath) {
		return dsl.obterValorAtributoValueWithXpath(xPath);
	}

	public void getSexo(String xPath) {
		dsl.selecionarRadioWithXpath(xPath);
	}
}
