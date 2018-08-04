package br.com.teste.suite.teste;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.dantas.teste.TesteCampoTreinamento;
import br.com.dantas.teste.TesteRegrasCadastro;
import br.com.dantas.teste.TesteValidarCampos;
import br.com.teste.core.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
		TesteRegrasCadastro.class,
		TesteValidarCampos.class, 
		TesteCampoTreinamento.class })

public class SuiteTestes {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}
}
