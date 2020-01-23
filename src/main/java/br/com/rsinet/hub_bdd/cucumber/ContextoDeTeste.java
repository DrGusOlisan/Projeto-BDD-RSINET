package br.com.rsinet.hub_bdd.cucumber;

import br.com.rsinet.hub_bdd.gerenciadores.PageObjectManager;
import br.com.rsinet.hub_bdd.gerenciadores.WebDriverManager;

public class ContextoDeTeste {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;

	public ContextoDeTeste() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.initDriver());
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
}
