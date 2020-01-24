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
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10 " + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Maven", "4.0.0");
		Reporter.setSystemInfo("Java Version", "1.8.0_231");
	}
}