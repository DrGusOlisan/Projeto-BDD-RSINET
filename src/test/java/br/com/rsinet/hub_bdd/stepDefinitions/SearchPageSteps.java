package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.pageObjectFactory.SearchPage_POF;
import cucumber.api.java.pt.Entao;

public class SearchPageSteps {
	
	SearchPage_POF searchPage;
	ContextoDeTeste contextoDeTeste;
	
	public SearchPageSteps(ContextoDeTeste contexto) {
		contextoDeTeste = contexto;
		searchPage = contextoDeTeste.getPageObjectManager().getSearchPage();
	}

	@Entao("^Produto pesquisado nao aparece na pagina de pesquisa$")
	public void produto_pesquisado_nao_aparece_na_pagina_de_pesquisa() throws Throwable {
		assertFalse(searchPage.validaPresencaDoProdutoInexistente());
	}
	
	@Entao("^Produto pesquisado aparece na pagina de pesquisa$")
	public void produto_pesquisado_aparece_na_pagina_de_pesquisa() throws Exception {
		assertTrue(searchPage.validaPresencaDoProdutoExistente());
	}
}
