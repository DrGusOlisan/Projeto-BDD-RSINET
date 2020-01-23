# language: pt
# encode: utf-8
Funcionalidade: Acao de pesquisa de produto
  Pesquisa de produto pelo campo de pesquisa

  Contexto: 
    Dado Usuario esta na pagina principal

  @CenarioPositivo
  Cenario: Pesquisar produto existente
    Quando Usuario insere o nome do produto existente no campo de pesquisa
    E executa a pesquisa
    Entao produto pesquisado aparece na pagina de pesquisa

  @CenarioNegativo
  Cenario: Pesquisar produto nao existente
    Quando Usuario insere o nome do produto inexistente no campo de pesquisa
    E executa a pesquisa
    Entao Produto pesquisado nao aparece na pagina de pesquisa
