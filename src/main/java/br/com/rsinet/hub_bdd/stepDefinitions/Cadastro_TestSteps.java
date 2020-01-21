package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.LoginPage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_bdd.utility.Constant;
import br.com.rsinet.hub_bdd.utility.DriverFactory;
import br.com.rsinet.hub_bdd.utility.ExcelUtils;
import br.com.rsinet.hub_bdd.utility.Screenshot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Cadastro_TestSteps {

	private static WebDriver driver;
	HomePage_POF HomePage;
	RegisterPage_POF RegisterPage;
	LoginPage_POF LoginPage;

	@Given("^Usuario esta na pagina principal$")
	public void usuario_esta_na_pagina_principal() {
		driver = DriverFactory.driverInit();
	}

	@When("^Usuario navega para a pagina de cadastro$")
	public void usuario_navega_para_a_pagina_de_cadastro() {
		HomePage = PageFactory.initElements(driver, HomePage_POF.class);
		RegisterPage = PageFactory.initElements(driver, RegisterPage_POF.class);

		HomePage.clicaEmBotaoConta();
		RegisterPage.clicaEmBotaoCriarConta();
	}

	@When("^Usuario preenche o formulario de cadastro$")
	public void usuario_preenche_o_formulario_de_cadastro() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, "CenariosDeTeste");

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

	@Then("^Usuario conclui o cadastro estando ja logado no sistema$")
	public void usuario_conclui_o_cadastro_logado_no_sistema() {
		RegisterPage.clicaNoBotaoRegistrar();
	}

	@Given("^Aplicacao reiniciada com usuario na pagina principal$")
	public void aplicacao_reiniciada_com_usuario_na_pagina_principal() {
		driver = DriverFactory.driverQuit();
		driver = DriverFactory.driverInit();
	}

	@When("^Usuario navega novamente para a pagina de cadastro$")
	public void usuario_navega_novamente_para_a_pagina_de_cadastro() {
		HomePage.clicaEmBotaoConta();
		RegisterPage.clicaEmBotaoCriarConta();
	}

	@When("^Usuario faz o cadastro de um usuario existente$")
	public void usuario_faz_o_cadastro_de_um_usuario_existente() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, "CenariosDeTeste");

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
		
		RegisterPage.clicaNoBotaoRegistrar();
	}

	@Then("^Mensagem mostrada usuario ja existente$")
	public void mensagem_mostrada_usuario_ja_existente() throws Exception {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		
		if (HomePage.nomeUsuarioLogadoApareceNaTela()) {
			Screenshot.printScreen(driver, "CadastroNaoRealizado", "");
		}
	}
}
