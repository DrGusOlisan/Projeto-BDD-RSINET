package br.com.rsinet.hub_bdd.cucumber;

import java.util.HashMap;
import java.util.Map;

import br.com.rsinet.hub_bdd.enums.Contexto;

public class ContextoDeCenario {
	
	private Map<String, Object> contextoDeCenario;

	public ContextoDeCenario(){
        contextoDeCenario = new HashMap<>();
    }

	public void setContexto(Contexto key, Object value) {
		contextoDeCenario.put(key.toString(), value);
	}

	public Object getContexto(Contexto key) {
		return contextoDeCenario.get(key.toString());
	}

	public Boolean isContains(Contexto key) {
		return contextoDeCenario.containsKey(key.toString());
	}
}
