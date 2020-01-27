# language: pt
# encode: utf-8
Funcionalidade: Acao de pesquisa de produto
  Pesquisa de produto pelo campo de pesquisa

  Contexto: 
    Dado Usuario esta na pagina principal

  @CenarioPesquisaPositivo
  Cenario: Pesquisar produto existente
    Quando Usuario inserir o nome do produto existente no campo de pesquisa
    E executa a pesquisa
    E aba de pesquisa se encontrar fechada
    Entao produto pesquisado aparece na pagina de pesquisa

  @CenarioPesquisaNegativo
  Cenario: Pesquisar produto nao existente
    Quando Usuario inserir o nome do produto inexistente no campo de pesquisa
    E executa a pesquisa
    Entao Produto pesquisado nao aparece na pagina de pesquisa
