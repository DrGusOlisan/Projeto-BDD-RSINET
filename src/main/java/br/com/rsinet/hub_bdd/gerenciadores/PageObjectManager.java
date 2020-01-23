package br.com.rsinet.hub_bdd.gerenciadores;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.pageObjectFactory.HomePage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.LoginPage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.ProductPage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_bdd.pageObjectFactory.SearchPage_POF;

public class PageObjectManager {
	private WebDriver driver;

	private HomePage_POF homePage;
	private LoginPage_POF loginPage;
	private RegisterPage_POF registerPage;
	private SearchPage_POF searchPage;
	private ProductPage_POF productPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage_POF getHomePage() {
		return (homePage == null) ? homePage = new HomePage_POF(driver) : homePage;
	}
	
	public LoginPage_POF getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage_POF(driver) : loginPage;
	}

	public RegisterPage_POF getRegisterPage() {
		return (registerPage == null) ? registerPage = new RegisterPage_POF(driver) : registerPage;
	}

	public SearchPage_POF getSearchPage() {
		return (searchPage == null) ? searchPage = new SearchPage_POF(driver) : searchPage;
	}

	public ProductPage_POF getProductPage() {
		return (productPage == null) ? productPage = new ProductPage_POF(driver) : productPage;
	}

}