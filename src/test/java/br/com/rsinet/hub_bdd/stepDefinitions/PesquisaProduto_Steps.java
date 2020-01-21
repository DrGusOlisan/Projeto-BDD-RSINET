package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.manager.PageObjectManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.SearchPage_POF;
import br.com.rsinet.hub_bdd.utility.Constant;
import br.com.rsinet.hub_bdd.utility.DriverFactory;
import br.com.rsinet.hub_bdd.utility.ExcelUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PesquisaProduto_Steps {

	private static WebDriver driver;
	HomePage_POF HomePage;
	SearchPage_POF SearchPage;
	PageObjectManager pageObjectManager;

	@Before
	public void initConfigs() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, Constant.sheet_DadosParaTeste);

		driver = DriverFactory.driverInit();

		HomePage = pageObjectManager.getHomePage();
		SearchPage = pageObjectManager.getSearchPage();

		HomePage.navegarParaPaginaPrincipal();
	}

	@After
	public void quitConfigs() {
		driver = DriverFactory.driverQuit();
	}

	@When("^Usuario insere o nome do produto existente no campo de pesquisa$")
	public void usuario_insere_o_nome_do_produto_existente_no_campo_de_pesquisa() throws Throwable {
		HomePage.pesquisarProduto(Constant.produtoExistente());
	}

	@When("^Usuario executa a pesquisa$")
	public void usuario_executa_a_pesquisa() {
		HomePage.executaPesquisa();
	}

	@Then("^Produto pesquisado aparece na pagina de pesquisa$")
	public void produto_pesquisado_aparece_na_pagina_de_pesquisa() throws Exception {
		assertTrue(SearchPage.validaPresencaDoProdutoExistente());
	}

	@When("^Usuario insere o nome do produto inexistente no campo de pesquisa$")
	public void usuario_insere_o_nome_do_produto_inexistente_no_campo_de_pesquisa() throws Exception {
		HomePage.pesquisarProduto(Constant.produtoInexistente());
	}

	@Then("^Produto pesquisado nao aparece na pagina de pesquisa$")
	public void produto_pesquisado_nao_aparece_na_pagina_de_pesquisa() throws Throwable {
		assertFalse(SearchPage.validaPresencaDoProdutoInexistente());
	}
}
