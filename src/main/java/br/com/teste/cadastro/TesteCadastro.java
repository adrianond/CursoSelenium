package br.com.teste.cadastro;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.teste.core.DriverFactory;



public class TesteCadastro {
	
	private TesteCadastroPage page = null;
	
	@Before
	public void inicializar(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	    page = new TesteCadastroPage();
	}
	
	@Test
	public void executaDesafio(){
		List<String> lista  = new ArrayList<String>();
		lista.add("Superior");
		List<String> listaEsporte  = new ArrayList<String>();
		listaEsporte.add("Corrida");
		
		page.setNome("adriano");	
		page.setSobreNome("Nogueira");
		page.setSexoMasculino();
		page.setComidaFrango();
		page.setEscolaridade(lista);
		page.setEsporte(listaEsporte);
		page.cadastrar();
		
		//Assert.assertTrue(page.obterNome().contains("adriano"));
		Assert.assertEquals("adriano", page.obterNomeByClassPath());
		
	}
}


