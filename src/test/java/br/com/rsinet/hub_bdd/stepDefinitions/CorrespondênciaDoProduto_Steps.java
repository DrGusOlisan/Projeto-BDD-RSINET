package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.manager.PageObjectManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.ProductPage_POF;
import br.com.rsinet.hub_bdd.utility.Constant;
import br.com.rsinet.hub_bdd.utility.DriverFactory;
import br.com.rsinet.hub_bdd.utility.ExcelUtils;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CorrespondênciaDoProduto_Steps {

	private static WebDriver driver;

	private HomePage_POF HomePage;
	private ProductPage_POF ProductPage;
	private PageObjectManager pageObjectManager;

	private String nomeDoPrimeiroProduto;
	private String nomeDoSegundoProduto;

	@Before
	public void initConfigs() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_DadosParaTeste, Constant.sheet_DadosParaTeste);

		driver = DriverFactory.driverInit();

		HomePage = pageObjectManager.getHomePage();
		ProductPage = pageObjectManager.getProductPage();

		HomePage.navegarParaPaginaPrincipal();
	}

	@After
	public void quitConfigs() {
		driver = DriverFactory.driverQuit();
	}

	@When("^Usuario navega para os produtos populares$")
	public void usuario_navega_para_os_produtos_populares() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
	}

	@When("^Usuario clica no primeiro produto$")
	public void usuario_clica_no_primeiro_produto() {
		nomeDoPrimeiroProduto = HomePage.getNomeDoPrimeiroProduto();
		HomePage.clicaNoPrimeiroProdutoPopular();
	}

	@Then("^Produto correspondente aparece na pagina do produto$")
	public void produto_correspondente_aparece_na_pagina_do_produto() {
		assertEquals(nomeDoPrimeiroProduto, ProductPage.getNomeDoProduto());
	}

	@When("^Usuario clica no segundo produto$")
	public void usuario_clica_no_segundo_produto() {
		nomeDoSegundoProduto = HomePage.getNomeDoSegundoProduto();
		HomePage.clicaNoSegundoProdutoPopular();
	}

	@Then("^Produto nao correspondente aparece na pagina do produto$")
	public void produto_nao_correspondente_aparece_na_pagina_do_produto() {
		assertNotEquals(nomeDoSegundoProduto, ProductPage.getNomeDoProduto());
	}
}
