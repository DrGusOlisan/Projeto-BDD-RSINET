package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.enums.Contexto;
import br.com.rsinet.hub_bdd.pageObjectFactory.ProductPage_POF;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.pt.Entao;

public class ProductPageSteps {

	ProductPage_POF productPage;
	ContextoDeTeste contextoDeTeste;

	public ProductPageSteps(ContextoDeTeste contexto) {
		contextoDeTeste = contexto;
		productPage = contextoDeTeste.getPageObjectManager().getProductPage();
	}

	@Entao("^Produto correspondente aparece na pagina do produto$")
	public void produto_correspondente_aparece_na_pagina_do_produto() throws Exception {
		String nomeDoProduto = (String) contextoDeTeste.contextoDeCenario.getContexto(Contexto.PRODUCT_NAME);
		assertEquals(nomeDoProduto, productPage.getNomeDoProduto());
		Reporter.addStepLog("O produto se encontra na pagina de execução de compra");
	}

	@Entao("^Produto nao correspondente aparece na pagina do produto$")
	public void produto_nao_correspondente_aparece_na_pagina_do_produto() throws Exception {
		String nomeDoProduto = (String) contextoDeTeste.contextoDeCenario.getContexto(Contexto.PRODUCT_NAME);
		assertNotEquals(nomeDoProduto, productPage.getNomeDoProduto());
		Reporter.addStepLog("Produto diferente aparece na pagina de execução de compra");
	}
}