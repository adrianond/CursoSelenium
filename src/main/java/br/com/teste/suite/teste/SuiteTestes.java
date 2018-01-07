package br.com.teste.suite.teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.teste.campo.treinamento.TesteCampoTreinamento;
import br.com.teste.campo.treinamento.ValidarCampos;
import br.com.teste.regras.cadastro.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({
	TesteRegrasCadastro.class,
	ValidarCampos.class,
	TesteCampoTreinamento.class
})
public class SuiteTestes {

}
