package br.com.rsinet.hub_bdd.stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.utils.ExcelUtils;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	ContextoDeTeste contextoDeTeste;

	public Hooks(ContextoDeTeste contexto) {
		this.contextoDeTeste = contexto;
	}

	@Before
	public void startConfigs() throws Exception {
		contextoDeTeste.getWebDriverManager().initDriver();

		ExcelUtils.setExcelFile(MassaDeDados.Path_DadosParaTeste, MassaDeDados.sheet_DadosParaTeste);
	}

	@After(order = 1)
	public void afterCenario(Scenario scenario) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed() || !scenario.isFailed()) {
			try {
				File sourcePath = ((TakesScreenshot) contextoDeTeste.getWebDriverManager().initDriver())
						.getScreenshotAs(OutputType.FILE);

				File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/"
						+ screenshotName + ".png");

				Files.copy(sourcePath, destinationPath);

				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		}
	}

	@After(order = 0)
	public void endDriver() {
		contextoDeTeste.getWebDriverManager().endDriver();
		Reporter.addScenarioLog("Aplicação Web é encerrada");
	}
}