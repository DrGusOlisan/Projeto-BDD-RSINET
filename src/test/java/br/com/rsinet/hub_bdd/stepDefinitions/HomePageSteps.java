package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertTrue;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.enums.Contexto;
import br.com.rsinet.hub_bdd.gerenciadores.WebDriverManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
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
		Reporter.addStepLog("Redirecionado para a pagina principal");
		
		Reporter.addScenarioLog("Aplicação Web é inicializada");
	}

	@Quando("^Usuario clica no botao de login$")
	public void usuario_clica_no_botao_de_login() {
		homePage.clicaEmBotaoLogin();
		Reporter.addStepLog("Botao de login clicado");
	}

	@Quando("^clica no botao de criar nova conta$")
	public void clica_no_botao_de_criar_nova_conta() {
		homePage.clicaEmBotaoCriarConta();
		Reporter.addStepLog("Botao criar nova conta clicado");
	}

	@Entao("^Usuario conclui o cadastro logado no sistema$")
	public void usuario_conclui_o_cadastro_logado_no_sistema() throws Exception {
		assertTrue(homePage.nomeUsuarioLogadoApareceNaTela());
		Reporter.addStepLog("Usuario cadastrado e logado");
	}

	@Quando("^Usuario navega para os produtos populares$")
	public void usuario_navega_para_os_produtos_populares() {
		homePage.navegarParaProdutosPopulares();
		Reporter.addStepLog("Navegado para os produtos populares da pagina principal");
	}

	@Quando("^Usuario clica no primeiro produto$")
	public void usuario_clica_no_primeiro_produto() {
		String nomePrimeiroProduto = homePage.getNomeDoPrimeiroProduto();
		contextoDeTeste.contextoDeCenario.setContexto(Contexto.PRODUCT_NAME, nomePrimeiroProduto);
		
		homePage.clicaNoPrimeiroProdutoPopular();
		Reporter.addStepLog(
				"Redirecionado para a pagina de compra do primeiro produto: " + homePage.getNomeDoPrimeiroProduto());
	}

	@Quando("^Usuario clica no segundo produto$")
	public void usuario_clica_no_segundo_produto() {
		String nomeSegundoProduto = homePage.getNomeDoSegundoProduto();
		contextoDeTeste.contextoDeCenario.setContexto(Contexto.PRODUCT_NAME, nomeSegundoProduto);
		
		homePage.clicaNoSegundoProdutoPopular();
		Reporter.addStepLog(
				"Redirecionado para a pagina de compra do segundo produto: " + homePage.getNomeDoSegundoProduto());
	}

	@Quando("^Usuario insere o nome do produto existente no campo de pesquisa$")
	public void usuario_insere_o_nome_do_produto_existente_no_campo_de_pesquisa() throws Exception {
		homePage.pesquisarProduto(MassaDeDados.produtoExistente());
		Reporter.addStepLog("Inserido no campo de pesquisa o nome de um produto existente: " + MassaDeDados.produtoExistente());
	}

	@Quando("^Usuario insere o nome do produto inexistente no campo de pesquisa$")
	public void usuario_insere_o_nome_do_produto_inexistente_no_campo_de_pesquisa() throws Exception {
		homePage.pesquisarProduto(MassaDeDados.produtoInexistente());
		Reporter.addStepLog("Inserido no campo de pesquisa o nome de um produto inexistente: " + MassaDeDados.produtoInexistente());
	}

	@Quando("^executa a pesquisa$")
	public void executa_a_pesquisa() {
		homePage.executaPesquisa();
		Reporter.addStepLog("Pesquisa executada");
	}

}