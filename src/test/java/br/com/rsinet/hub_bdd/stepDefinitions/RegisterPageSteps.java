package br.com.rsinet.hub_bdd.stepDefinitions;

import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.cucumber.listener.Reporter;

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
		Reporter.addStepLog("Nome de usuario inserido no campo Username");

		registerPage.insereEmail(MassaDeDados.email());
		Reporter.addStepLog("Email do usuario inserido no campo Email");
		
		registerPage.insereSenha(MassaDeDados.senha());
		Reporter.addStepLog("Nova senha inserida no campo Password");
		
		registerPage.confirmaSenha(MassaDeDados.senha());
		Reporter.addStepLog("Senha redigitada no campo Confirm Password");
		
		registerPage.insereNomeDoUsuario(MassaDeDados.nome());
		Reporter.addStepLog("Nome do usuario inserido no campo First Name");
		
		registerPage.insereSobrenomeDoUsuario(MassaDeDados.sobrenome());
		Reporter.addStepLog("Sobrenome do usuario inserido no campo Last Name");
		
		registerPage.insereTelefone(MassaDeDados.telefone());
		Reporter.addStepLog("Numero de telefone inserido no campo Phone Number");
		
		registerPage.insereNacionalidade(MassaDeDados.nacionalidade());
		Reporter.addStepLog("País selecionado no campo Country");
		
		registerPage.insereCidade(MassaDeDados.cidade());
		Reporter.addStepLog("Cidade inserida no campo City");
		
		registerPage.insereEndereco(MassaDeDados.endereco());
		Reporter.addStepLog("Endereço inserido no campo endereço");
		
		registerPage.insereEstado(MassaDeDados.estado());
		Reporter.addStepLog("Estado inserido no campo State / Province / Region");
		
		registerPage.insereCEP(MassaDeDados.cep());
		Reporter.addStepLog("CEP inserido no campo Postal Code");
		
		registerPage.clicaNoBotaoPromocoes();
		Reporter.addStepLog("Botao novas promoções deselecionado");
	}

	@Quando("^clica no botao de concordar com os termos$")
	public void clica_no_botao_de_concordar_com_os_termos() throws Throwable {
		registerPage.clicaNoBotaoTermos();
		Reporter.addStepLog("Botao concordar com os termos selecionado");
	}

	@Quando("^submete para cadastrar$")
	public void submete_para_cadastrar() throws Throwable {
		registerPage.clicaNoBotaoRegistrar();
		Reporter.addStepLog("Botao register clicado");
		
		Reporter.addScenarioLog("Formulário de cadastro preenchido e submetido");
	}

	@Entao("^Mostra mensagem usuario ja existente$")
	public void mostra_mensagem_usuario_ja_existente() throws Throwable {
		Actions actions = new Actions(contextoDeTeste.getWebDriverManager().initDriver());
		actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
		assertNotEquals(LeitorDeConfigsManager.getInstancia().getLeitorDeConfigs().getUrl(),
				contextoDeTeste.getWebDriverManager().initDriver().getCurrentUrl());
		Reporter.addStepLog("Mensagem Usuario Já Cadastrado aparece e cadastro não é concluído");
		
		Reporter.addScenarioLog("Cadastro não realizado");
		Reporter.addScenarioLog("Aplicação Web é encerrada");
	}
}