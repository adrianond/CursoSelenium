package br.com.teste.core;

import org.junit.After;

public class BaseTest {
	
	@After
	public void finaliza(){
		DriverFactory.killDriver();
	}

}
