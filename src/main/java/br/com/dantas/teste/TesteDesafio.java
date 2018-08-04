package br.com.dantas.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.dantas.page.DesafioPage;
import br.com.teste.core.BaseTest;
import br.com.teste.core.DriverFactory;

public class TesteDesafio extends BaseTest{
	
	private DesafioPage page = null;
	
	@Before
	public void iniciarCasoTeste(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new DesafioPage();
	}
	
	
	@Test
	public void executarCasoTeste(){
		escreverNome();
		selecionarRadioFeminino();
		selecionarComidaPizza();
		getUsuarioBTabelaSemHeader();
		clicarBotaoLinhaMaria();
		clicarRadioLinhaDoutorado();
		escreverInputLinhaSuperior();
	}
	
	private void escreverInputLinhaSuperior() {
		//há 2 Superior na coluna 2
		//colocar a expressão entre parenteses - (//*[@id='elementosForm:tableUsuarios']//td[2][.='Superior'])traz a resposta para mesmo nivel
		page.setInputLinhaSuperior("(//*[@id='elementosForm:tableUsuarios']//td[2][.='Superior'])[2]/..//input[@type='text']", "Superior");
	}
	
	private void clicarRadioLinhaDoutorado() {
		//*[@id='elementosForm:tableUsuarios']//td[1][.='Doutorado'] - coluna 1 com texto Doutorado
		// ..//td[2][.='Doutorado'] - coluna 2 com texto Doutorado
		page.clicarRadioLinhaDoutorado("//*[@id='elementosForm:tableUsuarios']//td[1][.='Doutorado']/..//td[2][.='Doutorado']/..//input[@type='radio']");
	}

	private void clicarBotaoLinhaMaria() {
		page.clicarBotaoLinhaMaria("//*[@id='elementosForm:tableUsuarios']//td[.='Maria']/..//input[@type='button']");
		//pega o evento externo a pagina, ou seja, o alert e fecha o alert, ou seja, clica no OK do alert
		page.clicarBotaoAlert();
	}

	private void getUsuarioBTabelaSemHeader() {
		String usuario = page.getUsuarioBTabelaSemHeader("//*[@id='tabelaSemJSF']//td[.='Usuario B']");
		Assert.assertEquals("Usuario B", usuario);
	}

	private void selecionarComidaPizza() {
		//volta 1 nivel para selecionar o label
		//page.getComidaPizza("//input[@id='elementosForm:comidaFavorita:2']/../label");
		page.getComidaPizza("//input[@id='elementosForm:comidaFavorita:2']/following-sibling::label");
	}

	private void selecionarRadioFeminino() {
		page.getSexoFeminino("//input[@name='elementosForm:sexo' and @value='F']");
	}

	private void escreverNome() {
		page.setNome("//input[@id='elementosForm:nome']", "Adriano");
	}

}
