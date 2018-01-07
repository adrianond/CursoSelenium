package br.com.teste.campo.treinamento;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.teste.validar.link.externo.GerarEventos;
import br.com.teste.validar.link.externo.GerarEventos;

public class DSL {
	
	private WebDriver driver = null;
	
	/**
	 * 
	 * @param driver
	 */
	public DSL(WebDriver driver){
	  this.driver = driver;
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escreve(String id_campo, String texto){
		driver.findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	/**
	 * 
	 * @param atributo
	 * @param texto
	 */
	public void recuperarBotao2(String componente, String atributo, String valorAtributo){
		
		if (atributo.equals("id")) {
			driver.findElement(By.id(valorAtributo)).click();
		} else if (atributo.equals("name")) {
			driver.findElement(By.name(valorAtributo)).click();
		} else if (atributo.equals("className")) {
			driver.findElement(By.className(valorAtributo)).click();
		} else if (atributo.equals("cssSelector")) {
			driver.findElement(By.cssSelector(valorAtributo)).click();
		} else if (atributo.equals("tagName")) {
			driver.findElement(By.tagName(valorAtributo)).click();
		} else {
			String component = "//".concat(componente);
			String attribute = "[@".concat(atributo).concat("=");
			String valueAttribute = "\'"+valorAtributo+"\'".concat("]");
			String xpath = component.concat(attribute).concat(valueAttribute);
			driver.findElement(By.xpath(xpath)).click();
		} 
	}
	
	/**
	 * 
	 * @param componente
	 * @param atributo
	 * @param valueAtributo
	 */
	public void recuperarBotao(String componente, String atributo, String valueAtributo){
		String component = "//".concat(componente);
		String attribute = "[@".concat(atributo).concat("=");
		String valueAttribute = "\'"+valueAtributo+"\'".concat("]");
		String xpath = component.concat(attribute).concat(valueAttribute);
		driver.findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escreve(By by, String texto){
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(texto);
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param value
	 * @return
	 */
	public String obterValorCampo(String id_campo){
		return driver.findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/**
	 * 
	 * @param id_campo
	 */
	public void clickButton(String id_campo){
		driver.findElement(By.id(id_campo)).click();
	}
	
	/**
	 * 
	 * @param atributeName
	 */
	public void clickButtonAtributeName(String atributeName){
		driver.findElement(By.name(atributeName)).click();
	}
	
	
	/**
	 * 
	 * @param id_campo
	 */
	public void selecionarRadio(String id_campo){
		driver.findElement(By.id(id_campo)).click();
	}

	/**
	 * 
	 * @param id_campo
	 */
	public void selecionarCheckBox(String id_campo){
		driver.findElement(By.id(id_campo)).click();
	}

	/**
	 * 
	 * @param id_campo
	 * @return
	 */
	public boolean isCheckBoxSelecionado(String id_campo) {
		return driver.findElement(By.id(id_campo)).isSelected();
		
	}

	/**
	 * Retorna Select
	 * @param id_campo
	 * @param lista
	 * @return
	 */
	public Select  recuperaItensSelecionadosCombo(String id_campo, List<String> lista) {
		WebElement element =  driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		for (String textContent :  lista){
			combo.selectByVisibleText(textContent);
		}
		return combo;
	}
	
	/**
	 * Retorna Select
	 * @param id_campo
	 * @param lista
	 * @return
	 */
	public void  selecionarValuesComboByTextContent(String id_campo, List<String> lista) {
		WebElement element =  driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		for (String textContent :  lista){
			combo.selectByVisibleText(textContent);
		}
	}

	public void selecionarValuesComboByValue(String id_campo, List<String> lista) {
		WebElement element =  driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		for (String value :  lista){
			combo.selectByValue(value);
		}
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param lista
	 * @return
	 */
	public void tirarSelecaoValuesComboByTextContent(String id_campo, List<String> lista) {
		WebElement element =  driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		for (String textContent :  lista){
			combo.deselectByVisibleText(textContent);
		}
	}

	/**
	 * 
	 * @param id_campo
	 * @return
	 */
	public String obterContentTexto(String id_campo) {
		return driver.findElement(By.id(id_campo)).getText();
	}
	
	/**
	 * 
	 * @param id_campo
	 */
	public void clicarLink(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}

	/**
	 * 
	 * @param componente
	 * @param atributo
	 * @param valueAtributo
	 * @return
	 */
	public GerarEventos recuperarButton(String componente, String atributo, String valueAtributo) {
		String component = "//".concat(componente);
		String attribute = "[@".concat(atributo).concat("=");
		String valueAttribute = "\'"+valueAtributo+"\'".concat("]");
		String xpath = component.concat(attribute).concat(valueAttribute);
		driver.findElement(By.xpath(xpath)).click();
		return null;
	}

	/**
	 * @return
	 */
	public Alert recuperarAlert(){
		return driver.switchTo().alert();
	}

	
}
