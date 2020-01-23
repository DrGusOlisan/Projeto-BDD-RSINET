package br.com.rsinet.hub_bdd.stepDefinitions;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	ContextoDeTeste contextoDeTeste;
	
	public Hooks(ContextoDeTeste contexto) {
		this.contextoDeTeste = contexto;
	}

	@Before
	public void startConfigs() throws Exception {
		contextoDeTeste.getWebDriverManager().initDriver();
		ExcelUtils.setExcelFile(MassaDeDados.Path_DadosParaTeste, MassaDeDados.sheet_DadosParaTeste);
	}

	@After
	public void endDriver() {
		contextoDeTeste.getWebDriverManager().endDriver();
	}
}