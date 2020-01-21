Feature: Acao de Cadastro 

Scenario: Cadastrar novo usuario com sucesso 
	Given Usuario esta na pagina principal 
	When Usuario navega para a pagina de cadastro 
	And Usuario preenche o formulario de cadastro 
	Then Usuario conclui o cadastro logado no sistema 
	
Scenario: Cadastrar usuario existente 
	Given Aplicacao reiniciada com usuario na pagina principal
	When Usuario navega novamente para a pagina de cadastro
	And Usuario faz o cadastro de um usuario existente
	Then Mensagem mostrada usuario ja existente