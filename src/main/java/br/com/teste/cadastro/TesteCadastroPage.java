package br.com.teste.cadastro;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.teste.dsl.DSL;

public class TesteCadastroPage {
	
	private DSL dsl;
	
	public TesteCadastroPage(WebDriver driver){
		dsl = new DSL(driver);
	}
	
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome){
		dsl.escreve("elementosForm:nome", nome);
	}

	/**
	 * 
	 * @param sobreNome
	 */
	public void setSobreNome(String sobreNome){
		dsl.escreve("elementosForm:sobreNome", sobreNome);
	}

	/**
	 * 
	 */
	public void setSexoMasculino(){
		dsl.selecionarRadio("elementosForm:sexo:0");
	}
	
	/**
	 * 
	 */
	
	public void setSexoFeminino(){
		dsl.selecionarRadio("elementosForm:sexo:1");
	}
	
	/**
	 * 
	 */
	public void setComidaFrango(){
		dsl.selecionarCheckBox("elementosForm:comidaFavorita:1");
	}
	
	/**
	 * 
	 */
	public void setVegetariano(){
		dsl.selecionarCheckBox("elementosForm:comidaFavorita:3");
	}
	
	/**
	 * 
	 */
	public boolean isComidaFrangoSelecionado(){
		return dsl.isCheckBoxSelecionado("elementosForm:comidaFavorita:1");
	}
	
	/**
	 * 
	 */
	public boolean isVegetarianoSelecionado(){
		return dsl.isCheckBoxSelecionado("elementosForm:comidaFavorita:3");
	}
	
	/**
	 * 
	 * @param lista
	 */
	public void setEscolaridade(List<String> lista ){
		dsl.selecionarValuesComboByTextContent("elementosForm:escolaridade", lista);
	}
	
	/**
	 * 
	 * @param listaEsporte
	 */
	public void setEsporte(List<String> listaEsporte){
		dsl.selecionarValuesComboByTextContent("elementosForm:esportes", listaEsporte);
	}
	
	/**
	 * 
	 */
	public void cadastrar(){
		dsl.clickButton("elementosForm:cadastrar");
	}
	
	/**
	 * @return 
	 * 
	 */
	public String obterNome(){
		return dsl.obterContentTexto("descNome");
	}
	
	/**
	 * @return 
	 * 
	 */
	public String obterNomeByClassPath(){
		return dsl.obterContentTextoByClassPath("//*[@id='descNome']/span");
	}
	
	/**
	 * 
	 * @return
	 */
	public String obterValorCampoNome(){
		return dsl.obterValorCampo("elementosForm:nome");
	}
	
	/**
	 * 
	 * @return
	 */
	public String obterValorCamposobreNome(){
		return dsl.obterValorCampo("elementosForm:sobreNome");
	}

	/**
	 * 
	 * @return
	 */
	public Alert validarAvisoAlert() {
		return dsl.clickBotaoAlert();
	}
	
	/**
	 * 
	 * @param lista
	 * @return
	 */
	public Select recuperarValoresCombo(List<String> lista ){
		return dsl.recuperaItensSelecionadosCombo("elementosForm:esportes", lista);
	}
	
	/**
	 * 
	 */
	public void escreveLImpaTexto(){
		dsl.escreve(By.id("elementosForm:nome"), "adriano");
		dsl.escreve(By.id("elementosForm:nome"), "dantas");
	}
}
