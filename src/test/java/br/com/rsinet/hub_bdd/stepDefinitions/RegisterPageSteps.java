package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import br.com.rsinet.hub_bdd.cucumber.ContextoDeTeste;
import br.com.rsinet.hub_bdd.gerenciadores.LeitorDeConfigsManager;
import br.com.rsinet.hub_bdd.pageObjectFactory.RegisterPage_POF;
import br.com.rsinet.hub_bdd.utils.MassaDeDados;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class RegisterPageSteps {

	RegisterPage_POF registerPage;
	ContextoDeTeste contextoDeTeste;

	public RegisterPageSteps(ContextoDeTeste contexto) {
		contextoDeTeste = contexto;
		registerPage = contextoDeTeste.getPageObjectManager().getRegisterPage();
	}

	@Quando("^preenche o formulario de cadastro$")
	public void preenche_o_formulario_de_cadastro() throws Throwable {
		registerPage.insereUsername(MassaDeDados.usuario());
		registerPage.insereEmail(MassaDeDados.email());
		registerPage.insereSenha(MassaDeDados.senha());
		registerPage.confirmaSenha(MassaDeDados.senha());
		registerPage.insereNomeDoUsuario(MassaDeDados.nome());
		registerPage.insereSobrenomeDoUsuario(MassaDeDados.sobrenome());
		registerPage.insereTelefone(MassaDeDados.telefone());
		registerPage.insereNacionalidade(MassaDeDados.nacionalidade());
		registerPage.insereCidade(MassaDeDados.cidade());
		registerPage.insereEndereco(MassaDeDados.endereco());
		registerPage.insereEstado(MassaDeDados.estado());
		registerPage.insereCEP(MassaDeDados.cep());

		registerPage.clicaNoBotaoPromocoes();
	}

	@Quando("^clica no botao de concordar com os termos$")
	public void clica_no_botao_de_concordar_com_os_termos() throws Throwable {
		registerPage.clicaNoBotaoTermos();
	}

	@Quando("^submete para cadastrar$")
	public void submete_para_cadastrar() throws Throwable {
		registerPage.clicaNoBotaoRegistrar();
	}

	@Entao("^Mostra mensagem usuario ja existente$")
	public void mostra_mensagem_usuario_ja_existente() throws Throwable {
		Actions actions = new Actions(contextoDeTeste.getWebDriverManager().initDriver());
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		assertNotEquals(LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getUrl(),
				contextoDeTeste.getWebDriverManager().initDriver().getCurrentUrl());
	}
}