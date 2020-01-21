Feature: Acao de Cadastro de usuario 
	Cadastra usuario no sistema. 

Scenario: Cadastrar novo usuario com sucesso 
	Given Usuario esta na pagina principal 
	When Usuario navega para a pagina de cadastro 
	And Usuario preenche o formulario de cadastro 
	Then Usuario conclui o cadastro logado no sistema 
	
Scenario: Cadastrar usuario existente 
	Given Usuario esta na pagina principal 
	When Usuario navega para a pagina de cadastro 
	And Usuario preenche o formulario de cadastro 
	Then Exibe mensagem usuario ja existente 
