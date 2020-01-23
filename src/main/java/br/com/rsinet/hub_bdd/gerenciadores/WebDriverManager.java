package br.com.rsinet.hub_bdd.gerenciadores;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {
	private WebDriver driver;
	private static Logger log = Logger.getLogger("DriverFactory");

	public WebDriver initDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			log.info("Driver inicializado");

			LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().maximizaJanela(driver);
			log.info("Navegador maximizado");

			driver.manage().timeouts().implicitlyWait(
					LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getImplicitlyWait(), TimeUnit.SECONDS);
			log.info("Comando de espera ImplicityWait inicializado");
		}
		return driver;
	}

	public WebDriver endDriver() {
		if (driver != null) {
			driver.close();
			log.info("Driver encerrado");
		}
		return driver = null;
	}
}