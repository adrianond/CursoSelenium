package br.com.dantas.teste;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.com.dantas.page.CadastroPage;
import br.com.teste.core.BaseTest;
import br.com.teste.core.DriverFactory;

@RunWith(Parameterized.class)
public class TesteRegrasCadastro extends BaseTest {
	
	public CadastroPage page = null;
	
	@Parameter
	public String nome;
	@Parameter(value=1)
	public String sobreNome;
	@Parameter(value=2)
	public String sexo;
	@Parameter(value=3)
	public List<String> listaComidas = null;
	@Parameter(value=4)
	public List<String> listaEsporte = null;
	@Parameter(value=5)
	public String msg;
	
	
	@Before
	public void inicializa(){
		DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		page = new CadastroPage();
	}
	
	
	@Parameters
	public static Collection<Object[]> getCollections(){
		return Arrays.asList(new Object[][] {
			//primeiro teste - nome obrigatorio
			{"", "", "", Arrays.asList(), Arrays.asList(), "Nome eh obrigatorio"},
			//segundo teste - sobreNome obrigatorio
			{"Adriano", "", "", Arrays.asList(), Arrays.asList(), "sobreNome eh obrigatorio"},
			//terceiro teste - sexo obrigatorio
			{"Adriano", "Dantas", "", Arrays.asList(), Arrays.asList(), "sexo eh obrigatorio"},
			//quarto teste - vegetariano?
			{"Adriano", "Dantas", "Masculino", Arrays.asList("Frango", "Vegetariano"), Arrays.asList(), "Tem certeza que voce eh vegetariano?"},
			//quinto teste - pratica esporte?
			{"Adriano", "Dantas", "Masculino", Arrays.asList("Frango"), Arrays.asList("Corrida", "O que eh esporte?"), "Voce faz esporte ou nao?"},
			
		});
	}
	
	@Test
	public void deveValidarRegras(){
		/*listaComidas.add("Frango");
		listaComidas.add("Vegetariano");*/
		
		/*listaEsporte.add("Corrida");
		listaEsporte.add("O que eh esporte?");
*/		
		page.setNome(nome);
		page.setSobreNome(sobreNome);
		
		if (sexo.equals("Masculino")){
			page.setSexoMasculino();
		} if (sexo.equals("Feminino")){
			page.setSexoMasculino();
		}
		if (listaComidas.contains("Frango"))page.setComidaFrango();
		if (listaComidas.contains("Vegetariano"))page.setVegetariano();
		page.setEsporte(listaEsporte);
		page.cadastrar();
		assertEquals(msg, page.validarAvisoAlert());
	}
	
	/*@Test
	public void deveValidarRegras2(){
		listaComidas.add("Frango");
		listaComidas.add("Vegetariano");
		
		listaEsporte.add("Corrida");
		listaEsporte.add("O que eh esporte?");
		
		page.setNome(nome);
		page.setSobreNome(sobreNome);
		
		if (sexo.equals("Masculino")){
			page.setSexoMasculino();
		} if (sexo.equals("Feminino")){
			page.setSexoFeminino();
		}
		if (listaComidas.contains("Frango"))page.setComidaFrango();
		if (listaComidas.contains("Vegetariano"))page.setVegetariano();
		page.setEsporte(listaEsporte);
		page.cadastrar();
		assertEquals(msg, page.validarAvisoAlert());
	}*/

}
