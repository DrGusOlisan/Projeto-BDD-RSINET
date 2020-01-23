Feature: Acao de selecao de produto 
	Valida correspondencia do produto na pagina do produto com o produto encontrado na pagina principal.

Scenario: Validar produto correspondente ao selecionado 
	Given Usuario esta na pagina principal 
	When Usuario navega para os produtos populares 
	And Usuario clica no primeiro produto 
	Then Produto correspondente aparece na pagina do produto 
	
Scenario: Validar produto nao correspondente ao selecionado 
	Given Usuario esta na pagina principal 
	When Usuario navega para os produtos populares 
	And Usuario clica no segundo produto 
	Then Produto nao correspondente aparece na pagina do produto 
