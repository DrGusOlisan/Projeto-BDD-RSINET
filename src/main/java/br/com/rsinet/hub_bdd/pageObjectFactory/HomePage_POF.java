package br.com.rsinet.hub_bdd.pageObjectFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_bdd.gerenciadores.LeitorDeConfigsManager;

public class HomePage_POF {

	WebDriver driver;
	private static Logger log = Logger.getLogger("HomePage Actions");

	public HomePage_POF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "menuUserLink")
	private WebElement botaoLogin;

	@FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	private WebElement botaoCriarConta;

	@FindBy(how = How.ID, using = "menuSearch")
	private WebElement botaoPesquisa;

	@FindBy(how = How.ID, using = "autoComplete")
	private WebElement campoPesquisa;

	@FindBy(how = How.XPATH, using = "//*[@id=\"menuUserLink\"]/span")
	private WebElement nomeUsuarioLogado;

	@FindBy(how = How.LINK_TEXT, using = "My account")
	private WebElement botaoMyAccount;

	@FindBy(how = How.LINK_TEXT, using = "My orders")
	private WebElement botaoMyOrders;

	@FindBy(how = How.CLASS_NAME, using = "option roboto-medium ng-scope")
	private WebElement botaoDeslogar;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[6]/a")
	private WebElement botaoPopularItems;

	@FindBy(how = How.XPATH, using = "//*[@id=\"popular_items\"]/h3")
	private WebElement pagePopularItems;

	@FindBy(how = How.ID, using = "details_16")
	private WebElement primeiroProdutoPopular;

	@FindBy(how = How.NAME, using = "popular_item_16_name")
	private WebElement nomeDoPrimeiroProduto;

	@FindBy(how = How.ID, using = "details_10")
	private WebElement segundoProdutoPopular;

	@FindBy(how = How.NAME, using = "popular_item_10_name")
	private WebElement nomeDoSegundoProduto;

	@FindBy(how = How.ID, using = "details_21")
	private WebElement terceiroProdutoPopular;

	@FindBy(how = How.NAME, using = "popular_item_21_name")
	private WebElement nomeDoTerceiroProduto;

	public void navegarParaPaginaPrincipal() {
		driver.get(LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getUrl());
	}

	public void clicaEmBotaoLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoLogin)).click();
	}

	public void clicaEmBotaoCriarConta() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoCriarConta)).sendKeys(Keys.ENTER);
	}

	public void clicaProdutosPopulares() {
		botaoPopularItems.click();
	}

	public void clicaNoPrimeiroProdutoPopular() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(primeiroProdutoPopular)).click();
	}

	public void clicaNoSegundoProdutoPopular() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(segundoProdutoPopular)).click();
	}

	public void clicaNoTerceiroProdutoPopular() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(terceiroProdutoPopular)).click();
	}

	public String getNomeDoPrimeiroProduto() {
		return nomeDoPrimeiroProduto.getText();
	}

	public String getNomeDoSegundoProduto() {
		return nomeDoSegundoProduto.getText();
	}

	public String getNomeDoTerceiroProduto() {
		return nomeDoTerceiroProduto.getText();
	}

	public void myAccount() {
		botaoMyAccount.click();
		log.info("Botao MyAccount clicado");
	}

	public void myOrders() {
		botaoMyOrders.click();
		log.info("Botao MyOrders clicado");
	}

	public void deslogar() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoDeslogar)).click();
		log.info("Botao SignOut clicado");
	}

	public void pesquisarProduto(String produto) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(botaoPesquisa)).click();
		log.info("Botao pesquisar clicado");

		wait.until(ExpectedConditions.elementToBeClickable(campoPesquisa)).sendKeys(produto);
		log.info("Nome do produto inserido: " + produto);
	}

	public void executaPesquisa() {
		campoPesquisa.sendKeys(Keys.ENTER);
		log.info("Produto pesquisado");
	}

	public boolean nomeUsuarioLogadoApareceNaTela() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			return wait.until(ExpectedConditions.elementToBeClickable(nomeUsuarioLogado)).isDisplayed();
		} catch (Exception e) {
			return wait.until(ExpectedConditions.elementToBeClickable(nomeUsuarioLogado)).isDisplayed();
		}
	}
	
	public void navegarParaProdutosPopulares() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
	}
}
