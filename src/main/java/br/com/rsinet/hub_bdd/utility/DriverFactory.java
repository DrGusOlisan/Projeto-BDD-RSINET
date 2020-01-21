package br.com.rsinet.hub_bdd.utility;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	private static WebDriver driver;
	private static Logger log = Logger.getLogger("DriverFactory");

	public static WebDriver driverInit() {
		if (driver == null) {
			driver = new ChromeDriver();
			log.info("Driver inicializado");

			driver.manage().window().maximize();
			log.info("Navegador maximizado");

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			log.info("Comando de espera ImplicityWait inicializado");
		}
		return driver;
	}

	public static WebDriver driverQuit() {
		if (driver != null) {
			driver.quit();
			log.info("Driver encerrado");
		}
		return driver = null;
	}
}
