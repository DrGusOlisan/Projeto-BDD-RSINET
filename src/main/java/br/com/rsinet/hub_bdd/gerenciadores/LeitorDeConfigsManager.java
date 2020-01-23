package br.com.rsinet.hub_bdd.gerenciadores;

import br.com.rsinet.hub_bdd.provedorDeDados.LeitorDeConfigs;

public class LeitorDeConfigsManager {

	private static LeitorDeConfigsManager leitorDeConfigs_Manager = new LeitorDeConfigsManager();
	private static LeitorDeConfigs leitorDeConfigs;

	private LeitorDeConfigsManager() {
	}

	public static LeitorDeConfigsManager getInstancia() {
		return leitorDeConfigs_Manager;
	}

	public LeitorDeConfigs getLeitorDeConfigs() {
		return (leitorDeConfigs == null) ? new LeitorDeConfigs() : leitorDeConfigs;
	}
}
