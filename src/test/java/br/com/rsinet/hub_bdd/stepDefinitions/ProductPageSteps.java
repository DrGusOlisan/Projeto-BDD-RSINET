package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.pageObjectFactory.ProductPage_POF;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.pt.Entao;

public class ProductPageSteps {

	ProductPage_POF productPage;
	ContextoDeTeste contextoDeTeste;

	String primeiroProduto;
	String segundoProduto;

	public ProductPageSteps(ContextoDeTeste contexto) {
		contextoDeTeste = contexto;
		productPage = contextoDeTeste.getPageObjectManager().getProductPage();
	}

	@Entao("^Produto correspondente aparece na pagina do produto$")
	public void produto_correspondente_aparece_na_pagina_do_produto() throws Exception {
		assertEquals(MassaDeDados.produtoCorrespondente(), productPage.getNomeDoProduto());
	}

	@Entao("^Produto nao correspondente aparece na pagina do produto$")
	public void produto_nao_correspondente_aparece_na_pagina_do_produto() throws Exception {
		assertNotEquals(MassaDeDados.produtoNaoCorrespondente(), productPage.getNomeDoProduto());
	}
}