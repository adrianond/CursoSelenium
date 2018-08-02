package br.com.teste.xpath;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.teste.core.DriverFactory;



/**
 * Classe de teste
 * Chama a classe UsarXpathPage - padrão pageObject
 * @author adriano
 *
 */
public class UsarXpathTeste {
	
	WebDriver driver = null;
	UsarXpathPage page =null;
	
	@Before
	public void inicializa(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new UsarXpathPage();
	}
	
	@Test
	public void executarTeste(){
		obterTextoElemento();
		escreverNome();
		getNome();
		clicarBotao();
		selecionarSexo();
	}
	
	
	private void selecionarSexo() {
		//page.getSexo("//input[@name='elementosForm:sexo' and @value='F']");//usando dois atributos
		//page.getSexo("//*[.=' Feminino']");
		page.getSexo("//label[.=' Feminino']/../input");//..(ponto,ponto), vai para o nivel anterior(neste caso o 'td'),depois volto para input(proximo elemento)
	}

	private void clicarBotao() {
		//page.clicarBotao("//input[@id='buttonSimple']");
		//page.clicarBotao("//*[@id='buttonSimple']");
		//page.clicarBotao("//input[@value='Clique Me!']");
		page.clicarBotao("//input[@type='button'][1]");//neste caso funciona, pois os botões estão alinhados
		String texto  = page.obterValueButton("//input[@id='buttonSimple']");
		Assert.assertEquals("Obrigado!", texto);
	}

	private void getNome() {
		String texto = page.getNome("//input[@id='elementosForm:nome']");
		Assert.assertEquals("Adriano", texto);
	}

	private void obterTextoElemento(){
		//absoluto
		//String texto  = page.obterTextoElemento("/html/body/center/form/h3");
		//relativo
		String texto  = page.obterTextoElemento("//h3");
		Assert.assertEquals("Campo de Treinamento", texto);
	}
	
	private void escreverNome(){
		page.setNome("//input[@id='elementosForm:nome']", "Adriano");
	}

}
