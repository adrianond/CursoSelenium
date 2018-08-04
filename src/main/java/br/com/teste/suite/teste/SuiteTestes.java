package br.com.teste.suite.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.dantas.teste.TesteCampoTreinamento;
import br.com.dantas.teste.TesteValidarCampos;

@RunWith(Suite.class)
@SuiteClasses({
	//TesteRegrasCadastro.class,
	TesteValidarCampos.class,
	TesteCampoTreinamento.class
})
public class SuiteTestes {

}
