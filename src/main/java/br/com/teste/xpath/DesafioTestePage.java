package br.com.teste.xpath;

import org.openqa.selenium.WebDriver;

import br.com.teste.dsl.DSL;

public class DesafioTestePage {

	private DSL dsl = null;

	public DesafioTestePage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	/**
	 * 
	 * @param xPath
	 * @param texto
	 */
	public void setNome(String xPath, String texto) {
		dsl.escreveWithXpath(xPath, texto);
	}

	/**
	 * 
	 * @param xPath
	 */
	public void getSexoFeminino(String xPath) {
		dsl.selecionarRadioWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 */
	public void getComidaPizza(String xPath) {
		dsl.selecionarCheckBoxWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 * @return
	 */
	public String getUsuarioBTabelaSemHeader(String xPath) {
		return dsl.recuperarTextoElementoWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 */
	public void clicarBotaoLinhaMaria(String xPath) {
		dsl.clicarBotaoWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 */
	public void clicarRadioLinhaDoutorado(String xPath) {
		dsl.selecionarRadioWithXpath(xPath);
	}

	/**
	 * 
	 * @param xPath
	 * @param texto
	 */
	public void setInputLinhaSuperior(String xPath, String texto) {
		dsl.escreveWithXpath(xPath, texto);
	}

	/**
	 * 
	 */
	public void clicarBotaoAlert() {
		dsl.clicarBotaoAlert();
	}
}
