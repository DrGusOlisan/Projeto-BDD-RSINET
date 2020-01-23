package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.gerenciadores.WebDriverManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Quando;

public class HomePageSteps {

	HomePage_POF homePage;
	WebDriverManager webDriverManager;
	ContextoDeTeste contextoDeTeste;
	
	public HomePageSteps(ContextoDeTeste contexto) {
		this.contextoDeTeste = contexto;
		homePage = contextoDeTeste.getPageObjectManager().getHomePage();
	}

	@Dado("^Usuario esta na pagina principal$")
	public void usuario_esta_na_pagina_principal() {
		homePage.navegarParaPaginaPrincipal();
	}

	@Quando("^Usuario navega para os produtos populares$")
	public void usuario_navega_para_os_produtos_populares() {
		Actions actions = new Actions(contextoDeTeste.getWebDriverManager().initDriver());
		actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
	}

	@E("^Usuario clica no primeiro produto$")
	public void usuario_clica_no_primeiro_produto() {
		String nomeDoPrimeiroProduto = homePage.getNomeDoPrimeiroProduto();
		homePage.clicaNoPrimeiroProdutoPopular();
	}

	@E("^Usuario clica no segundo produto$")
	public void usuario_clica_no_segundo_produto() {
		String nomeDoSegundoProduto = homePage.getNomeDoSegundoProduto();
		homePage.clicaNoSegundoProdutoPopular();
	}

	@Quando("^Usuario insere o nome do produto existente no campo de pesquisa$")
	public void usuario_insere_o_nome_do_produto_existente_no_campo_de_pesquisa() throws Throwable {
		homePage.pesquisarProduto(MassaDeDados.produtoExistente());
	}

	@Quando("^Usuario insere o nome do produto inexistente no campo de pesquisa$")
	public void usuario_insere_o_nome_do_produto_inexistente_no_campo_de_pesquisa() throws Exception {
		homePage.pesquisarProduto(MassaDeDados.produtoInexistente());
	}

	@E("^Usuario executa a pesquisa$")
	public void usuario_executa_a_pesquisa() {
		homePage.executaPesquisa();
	}
}
