package br.com.rsinet.hub_bdd.provedorDeDados;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.gerenciadores.LeitorDeConfigsManager;

public class LeitorDeConfigs {

	private Properties properties;
	private final String propertyFilePath = "configs/Configuracoes.properties";

	public LeitorDeConfigs() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuracoes.properties nao encontrado em " + propertyFilePath);
		}
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("incapaz de analisar o valor: " + implicitlyWait + " em formato Long.");
			}
		}
		return 15;
	}

	public String getUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url nao especificada no arquivo Configuracoes.properties.");
	}

	public void maximizaJanela(WebDriver driver) {
		if (LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getTamanhoDaJanelaDoNavegador())
			driver.manage().window().maximize();
	}

	private Boolean getTamanhoDaJanelaDoNavegador() {
		String tamanhoDaJanela = properties.getProperty("maximizarJanela");
		if (tamanhoDaJanela != null)
			return Boolean.valueOf(tamanhoDaJanela);
		return true;
	}

	public String getConfigDoCaminhoDoReport() {
		String caminhoDaConfigDoReport = properties.getProperty("caminhoDaConfigDoReport");
		if (caminhoDaConfigDoReport != null)
			return caminhoDaConfigDoReport;
		else
			throw new RuntimeException(
					"Caminho da configuracao do report nao especificado no arquivo Configuracao.properties pela chave: caminhoDaConfigDoReport");
	}
	
	public String getConfigDoCaminhoDoExcel() {
		String caminhoDaConfigDoReport = properties.getProperty("caminhoExcel");
		if (caminhoDaConfigDoReport != null)
			return caminhoDaConfigDoReport;
		else
			throw new RuntimeException(
					"Caminho da arquivo Excel nao especificado no arquivo Configuracao.properties pela chave: caminhoExcel");
	}

}