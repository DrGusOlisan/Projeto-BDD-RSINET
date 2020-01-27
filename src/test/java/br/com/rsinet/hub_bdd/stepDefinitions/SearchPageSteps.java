package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.pageObjectFactory.SearchPage_POF;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class SearchPageSteps {

	SearchPage_POF searchPage;
	ContextoDeTeste contextoDeTeste;

	public SearchPageSteps(ContextoDeTeste contexto) {
		contextoDeTeste = contexto;
		searchPage = contextoDeTeste.getPageObjectManager().getSearchPage();
	}
	
	@Quando("^aba de pesquisa se encontrar fechada$")
	public void aba_de_pesquisa_se_encontrar_fechada() {
		searchPage.fecharPesquisa();
		Reporter.addStepLog("Aba de pesquisa é fechada");
	}

	@Entao("^produto pesquisado aparece na pagina de pesquisa$")
	public void produto_pesquisado_aparece_na_pagina_de_pesquisa() throws Exception {
		assertTrue(searchPage.validaPresencaDoProdutoExistente());
		Reporter.addStepLog("Produto existente aparece na pagina");

		Reporter.addScenarioLog("Produto existente aparece na pagina");
		Reporter.addScenarioLog("Aplicação Web é encerrada");
	}

	@Entao("^Produto pesquisado nao aparece na pagina de pesquisa$")
	public void produto_pesquisado_nao_aparece_na_pagina_de_pesquisa() throws Exception {
		assertFalse(searchPage.validaPresencaDoProdutoInexistente());
		Reporter.addStepLog("Produto inexistente não aparece");
		
		Reporter.addScenarioLog("Produto inexistente não aparece na pagina");
	}
}