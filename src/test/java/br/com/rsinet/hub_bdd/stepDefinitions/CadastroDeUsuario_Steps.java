package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import br.com.rsinet.hub_bdd.manager.PageObjectManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.SearchPage_POF;
import br.com.rsinet.hub_bdd.utility.Constant;
import br.com.rsinet.hub_bdd.utility.DriverFactory;
import br.com.rsinet.hub_bdd.utility.ExcelUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cadastro_Steps {

	private static WebDriver driver;
	HomePage_POF HomePage;
	RegisterPage_POF RegisterPage;
	SearchPage_POF SearchPage;
	PageObjectManager pageObjectManager;

	@Before
	public void initConfigs() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, Constant.sheet_DadosParaTeste);
		
		driver = DriverFactory.driverInit();
		
		HomePage = pageObjectManager.getHomePage();
		RegisterPage = pageObjectManager.getRegisterPage();
		SearchPage = pageObjectManager.getSearchPage();
		
		HomePage.navegarParaPaginaPrincipal();
	}

	@After
	public void quitConfigs() {
		driver = DriverFactory.driverQuit();
	}

	@Given("^Usuario esta na pagina principal$")
	public void usuario_esta_na_pagina_principal() {
		driver.get(Constant.url);
	}

	@When("^Usuario navega para a pagina de cadastro$")
	public void usuario_navega_para_a_pagina_de_cadastro() {
		HomePage.clicaEmBotaoConta();
		RegisterPage.clicaEmBotaoCriarConta();
	}

	@When("^Usuario preenche o formulario de cadastro$")
	public void usuario_preenche_o_formulario_de_cadastro() throws Exception {
		RegisterPage.insereUsername(Constant.usuario());
		RegisterPage.insereEmail(Constant.email());
		RegisterPage.insereSenha(Constant.senha());
		RegisterPage.confirmaSenha(Constant.senha());
		RegisterPage.insereNomeDoUsuario(Constant.nome());
		RegisterPage.insereSobrenomeDoUsuario(Constant.sobrenome());
		RegisterPage.insereTelefone(Constant.telefone());
		RegisterPage.insereNacionalidade(Constant.nacionalidade());
		RegisterPage.insereCidade(Constant.cidade());
		RegisterPage.insereEndereco(Constant.endereco());
		RegisterPage.insereEstado(Constant.estado());
		RegisterPage.insereCEP(Constant.cep());

		RegisterPage.clicaNoBotaoPromocoes();
		RegisterPage.clicaNoBotaoTermos();
	}

	@Then("^Usuario conclui o cadastro logado no sistema$")
	public void usuario_conclui_o_cadastro_logado_no_sistema() throws Exception {
		RegisterPage.clicaNoBotaoRegistrar();
		assertEquals(HomePage.nomeUsuarioLogado(), Constant.usuario());
	}

	@Then("^Exibe mensagem usuario ja existente$")
	public void exibe_mensagem_usuario_ja_existente() throws Throwable {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		assertNotEquals(Constant.url, driver.getCurrentUrl());
	}
}
