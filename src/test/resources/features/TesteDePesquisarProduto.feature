Feature: Acao de pesquisa de produto 
	Pesquisa de produto pelo campo de pesquisa

Scenario: Pesquisar produto existente 
	Given Usuario esta na pagina principal 
	When Usuario insere o nome do produto existente no campo de pesquisa 
	And Usuario executa a pesquisa 
	Then Produto pesquisado aparece na pagina de pesquisa 
	
Scenario: Pesquisar produto nao existente 
	Given Usuario esta na pagina principal 
	When Usuario insere o nome do produto inexistente no campo de pesquisa 
	And Usuario executa a pesquisa 
	Then Produto pesquisado nao aparece na pagina de pesquisa 
