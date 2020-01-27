package br.com.rsinet.hub_bdd.cucumber;

import br.com.rsinet.hub_bdd.gerenciadores.PageObjectManager;
import br.com.rsinet.hub_bdd.gerenciadores.WebDriverManager;

public class ContextoDeTeste {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ContextoDeCenario contextoDeCenario;

	public ContextoDeTeste() {
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.initDriver());
		contextoDeCenario = new ContextoDeCenario();
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ContextoDeCenario getContextoDeCenario() {
		return contextoDeCenario;
	}
}
