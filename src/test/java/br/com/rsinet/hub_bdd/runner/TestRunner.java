package br.com.rsinet.hub_bdd.runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.gerenciadores.LeitorDeConfigsManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "br.com.rsinet.hub_bdd.stepDefinitions" }, tags = {
		"@CenarioPositivo, @CenarioNegativo" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)
public class TestRunner {
	@AfterClass
	public static void gerarExtentReport() {
		Reporter.loadXMLConfig(
				new File(LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getConfigDoCaminhoDoReport()));
	}
}