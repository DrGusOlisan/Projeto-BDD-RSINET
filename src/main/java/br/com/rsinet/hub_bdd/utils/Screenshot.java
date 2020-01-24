package br.com.rsinet.hub_bdd.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;

public class Screenshot {

	public void printScreen(ContextoDeTeste contexto, String nomeDoPrint) {
		try {
			File sourcePath = ((TakesScreenshot) contexto.getWebDriverManager().initDriver())
					.getScreenshotAs(OutputType.FILE);

			File destinationPath = new File(
					System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + nomeDoPrint + ".png");

			Files.copy(sourcePath, destinationPath);

			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
		}

	}
}