package br.com.teste.core;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DSL {
	
	/**
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escreve(String id_campo, String texto){
		DriverFactory.getDriver().findElement(By.id(id_campo)).sendKeys(texto);
	}
	
	/**
	 * 
	 * @param atributo
	 * @param texto
	 */
	public void recuperarBotao2(String componente, String atributo, String valorAtributo){
		
		if (atributo.equals("id")) {
			DriverFactory.getDriver().findElement(By.id(valorAtributo)).click();
		} else if (atributo.equals("name")) {
			DriverFactory.getDriver().findElement(By.name(valorAtributo)).click();
		} else if (atributo.equals("className")) {
			DriverFactory.getDriver().findElement(By.className(valorAtributo)).click();
		} else if (atributo.equals("cssSelector")) {
			DriverFactory.getDriver().findElement(By.cssSelector(valorAtributo)).click();
		} else if (atributo.equals("tagName")) {
			DriverFactory.getDriver().findElement(By.tagName(valorAtributo)).click();
		} else {
			String component = "//".concat(componente);
			String attribute = "[@".concat(atributo).concat("=");
			String valueAttribute = "\'"+valorAtributo+"\'".concat("]");
			String xpath = component.concat(attribute).concat(valueAttribute);
			DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
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
		DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escreve(By by, String texto){
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param value
	 * @return
	 */
	public String obterValorCampo(String id_campo){
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
	}
	
	/**
	 * 
	 * @param id_campo
	 */
	public void clickButton(String id_campo){
		DriverFactory.getDriver().findElement(By.id(id_campo)).click();
	}
	
	/**
	 * 
	 * @param atributeName
	 */
	public void clickButtonAtributeName(String atributeName){
		DriverFactory.getDriver().findElement(By.name(atributeName)).click();
	}
	
	
	/**
	 * 
	 * @param id_campo
	 */
	public void selecionarRadio(String id_campo){
		DriverFactory.getDriver().findElement(By.id(id_campo)).click();
	}

	/**
	 * 
	 * @param id_campo
	 */
	public void selecionarCheckBox(String id_campo){
		DriverFactory.getDriver().findElement(By.id(id_campo)).click();
	}

	/**
	 * 
	 * @param id_campo
	 * @return
	 */
	public boolean isCheckBoxSelecionado(String id_campo) {
		return DriverFactory.getDriver().findElement(By.id(id_campo)).isSelected();
		
	}

	/**
	 * Retorna Select
	 * @param id_campo
	 * @param lista
	 * @return
	 */
	public Select  recuperaItensSelecionadosCombo(String id_campo, List<String> lista) {
		WebElement element =  DriverFactory.getDriver().findElement(By.id(id_campo));
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
		WebElement element =  DriverFactory.getDriver().findElement(By.id(id_campo));
		Select combo = new Select(element);
		for (String textContent :  lista){
			combo.selectByVisibleText(textContent);
		}
	}

	public void selecionarValuesComboByValue(String id_campo, List<String> lista) {
		WebElement element =  DriverFactory.getDriver().findElement(By.id(id_campo));
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
		WebElement element =  DriverFactory.getDriver().findElement(By.id(id_campo));
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
		return DriverFactory.getDriver().findElement(By.id(id_campo)).getText();
	}
	
	/**
	 * 
	 * @param id_campo
	 * @return
	 */
	public String obterContentTextoByClassPath(String classPath) {
		return DriverFactory.getDriver().findElement(By.xpath(classPath)).getText();
	}
	
	/**
	 * 
	 * @param id_campo
	 */
	public void clicarLink(String id_campo) {
		DriverFactory.getDriver().findElement(By.id(id_campo)).click();
	}

	/**
	 * 
	 * @param componente
	 * @param atributo
	 * @param valueAtributo
	 * @return
	 */
	public void recuperarButton(String componente, String atributo, String valueAtributo) {
		String component = "//".concat(componente);
		String attribute = "[@".concat(atributo).concat("=");
		String valueAttribute = "\'"+valueAtributo+"\'".concat("]");
		String xpath = component.concat(attribute).concat(valueAttribute);
		DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
	}

	/**
	 * @return
	 */
	public void clicarBotaoAlert(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		alert.accept();
	}
	
	/**
	 * @return
	 */
	public Alert clickBotaoAlert(){
		return  DriverFactory.getDriver().switchTo().alert();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public WebElement getElementById(String id){
		return DriverFactory.getDriver().findElement(By.id(id));
	}
	
	/****** JAVASCRIPT INI********/
	
	public Object executarJS(String comando, Object... param){
		JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
		// js.executeScript("alert('Testando js via Selenium')");
		js.executeScript("document.getElementById('elementosForm:nome').value = 'Escrito via JS'");
		//js.executeScript("document.getElementById('elementosForm:sobreNome').type = 'radio'");
		return js.executeScript(comando, param);
	}
	
	/****** JAVASCRIPT FIM ********/
	
	/**
	 * 
	 * @param id
	 */
	public void recuperarFrame(String id){
		DriverFactory.getDriver().switchTo().frame(id);
	}

	/**
	 * 
	 */
	public void retiraFocoFrame() {
		DriverFactory.getDriver().switchTo().defaultContent();
	}

	/**
	 * 
	 * @param name
	 */
	public void inserirFocoPoupup(String name) {
		DriverFactory.getDriver().switchTo().window(name);
	}

	/****** xPath inicio ********/
	
	/**
	 * 
	 * @param xPath
	 */
	public String recuperarTextoElementoWithXpath(String xPath) {
		return DriverFactory.getDriver().findElement(By.xpath(xPath)).getText();
	}

	/**
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escreveWithXpath(String xPath, String texto){
		 DriverFactory.getDriver().findElement(By.xpath(xPath)).sendKeys(texto);
	}

	/**
	 * 
	 * @param xPath
	 * @return
	 */
	public String recuperaTextoDigitadoWithXpath(String xPath) {
		return DriverFactory.getDriver().findElement(By.xpath(xPath)).getAttribute("value");
	}

	/**
	 * 
	 * @param xPath
	 */
	public void clicarBotaoWithXpath(String xPath) {
		DriverFactory.getDriver().findElement(By.xpath(xPath)).click();
	}

	/**
	 * 
	 * @param xPath
	 * @return
	 */
	public String obterValorAtributoValueWithXpath(String xPath) {
	   return DriverFactory.getDriver().findElement(By.xpath(xPath)).getAttribute("value");
	}

	/**
	 * 
	 * @param xPath
	 */
	public void selecionarRadioWithXpath(String xPath) {
		DriverFactory.getDriver().findElement(By.xpath(xPath)).click();
	}

	/**
	 * 
	 * @param xPath
	 */
	public void selecionarCheckBoxWithXpath(String xPath) {
		DriverFactory.getDriver().findElement(By.xpath(xPath)).click();
	}
	
	/**
	 * 
	 * @param by
	 */
	public void clicarRadio(By by) {
		DriverFactory.getDriver().findElement(by).click();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isRadioMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	/**
	 * 
	 * @param by
	 * @return
	 */
	public String obterTexto(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
    /************** Tabela Inicio*********************/
	
	/**
	 * 
	 * @param colunaBusca
	 * @param valor
	 * @param colunaBotao
	 * @param idTabela
	 */
	public void clicarBotaoTabela(String colunaBusca, String valor, String colunaBotao, String idTabela){
		//procurar coluna do registro
		WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
		
		int idColuna = obterIndiceColuna(colunaBusca, tabela);
		
		//encontrar a linha do registro
		int idLinha = obterIndiceLinha(valor, tabela, idColuna);
		
		//procurar coluna do botao/elemento que desejo
		int idColunaElemento = obterIndiceColuna(colunaBotao, tabela);
		
		//clicar no botao da celula encontrada
		WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinha+"]/td["+idColunaElemento+"]"));
		celula.findElement(By.xpath(".//input")).click();
		
	}
	
	/**
	 * 
	 * @param valor
	 * @param tabela
	 * @param idColuna
	 * @return
	 */
	protected int obterIndiceLinha(String valor, WebElement tabela, int idColuna) {
		List<WebElement> linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idColuna+"]"));
		int idLinha = -1;
		for(int i = 0; i < linhas.size(); i++) {
			if(linhas.get(i).getText().equals(valor)) {
				idLinha = i+1;
				break;
			}
		}
		System.out.println(" Indice da linha " + idLinha);
		return idLinha;
	}
	
    /**
     * Vai até um ID, sobe dois niveis e clica em um span
     * @param radical
     * @param valor
     */
	public void selecionarComboPrime(String radical, String valor) {
		clicarRadio(By.xpath("//*[@id='"+radical+"_input']/../..//span"));
		clicarRadio(By.xpath("//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}

	/**
	 * 
	 * @param coluna
	 * @param tabela
	 * @return
	 */
	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		////traz todos os registros -  tabela.findElements
		// usa o ponto no inicio do classPath (.//th) para continuar do escopo
		//no qual me encontro, ou seja, no escopo do componente, neste caso a tabela ,pois quero os titulos da tabela (classPath absoluto)
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		int idColuna = -1;
		for(int i = 0; i < colunas.size(); i++) {
			if(colunas.get(i).getText().equals(coluna)) {
				idColuna = i+1;
				break;
			}
		}
		System.out.println("Indice  da coluna " + idColuna);
		return idColuna;
	}
	
	 /************** Tabela Fim*********************/
	
     /********* Botao ************/
	
	/**
	 * 
	 * @param id
	 */
	public void clicarBotao(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	
    /********* TextField e TextArea ************/
	
	/**
	 * 
	 * @param by
	 * @param texto
	 */
	public void escrever(By by, String texto){
		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	
	/**
	 * 
	 * @param id_campo
	 * @param texto
	 */
	public void escrever(String id_campo, String texto){
		escrever(By.id(id_campo), texto);
	}
	
}
