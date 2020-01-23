package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.gerenciadores.LeitorDeConfigsManager;
import br.com.rsinet.hub_bdd.gerenciadores.WebDriverManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RegisterPageSteps {

	HomePage_POF homePage;
	RegisterPage_POF registerPage;
	WebDriverManager webDriverManager;
	ContextoDeTeste contextoDeTeste;

	public RegisterPageSteps(ContextoDeTeste contexto) {
		contextoDeTeste = contexto;
		contextoDeTeste.getWebDriverManager().initDriver();
		homePage = contextoDeTeste.getPageObjectManager().getHomePage();
		registerPage = contextoDeTeste.getPageObjectManager().getRegisterPage();
	}

	@Quando("^Usuario navega para a pagina de cadastro$")
	public void usuario_navega_para_a_pagina_de_cadastro() {
		homePage.clicaEmBotaoConta();
		registerPage.clicaEmBotaoCriarConta();
	}

	@E("^Usuario preenche o formulario de cadastro$")
	public void usuario_preenche_o_formulario_de_cadastro() throws Exception {
		registerPage.insereUsername(MassaDeDados.usuario());
		registerPage.insereEmail(MassaDeDados.email());
		registerPage.insereSenha(MassaDeDados.senha());
		registerPage.confirmaSenha(MassaDeDados.senha());
		registerPage.insereNomeDoUsuario(MassaDeDados.nome());
		registerPage.insereSobrenomeDoUsuario(MassaDeDados.sobrenome());
		registerPage.insereTelefone(MassaDeDados.telefone());
		registerPage.insereNacionalidade(MassaDeDados.nacionalidade());
		registerPage.insereCidade(MassaDeDados.cidade());
		registerPage.insereEndereco(MassaDeDados.endereco());
		registerPage.insereEstado(MassaDeDados.estado());
		registerPage.insereCEP(MassaDeDados.cep());

		registerPage.clicaNoBotaoPromocoes();
		registerPage.clicaNoBotaoTermos();
	}

	@Entao("^Usuario conclui o cadastro logado no sistema$")
	public void usuario_conclui_o_cadastro_logado_no_sistema() throws Exception {
		registerPage.clicaNoBotaoRegistrar();
		assertTrue(homePage.nomeUsuarioLogadoApareceNaTela());
	}

	@Entao("^Mostra mensagem usuario ja existente$")
	public void mostra_mensagem_usuario_ja_existente() throws Throwable {
		Actions actions = new Actions(contextoDeTeste.getWebDriverManager().initDriver());
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		assertNotEquals(LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getUrl(), contextoDeTeste.getWebDriverManager().initDriver().getCurrentUrl());
	}

}
