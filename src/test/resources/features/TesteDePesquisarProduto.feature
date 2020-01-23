# language: pt
# encode: utf-8
Funcionalidade: Acao de pesquisa de produto
  Pesquisa de produto pelo campo de pesquisa

  Cenario: Pesquisar produto existente
    Dado Usuario esta na pagina principal
    Quando Usuario insere o nome do produto existente no campo de pesquisa
    E Usuario executa a pesquisa
    Entao Produto pesquisado aparece na pagina de pesquisa

  Cenario: Pesquisar produto nao existente
    Dado Usuario esta na pagina principal
    Quando Usuario insere o nome do produto inexistente no campo de pesquisa
    E Usuario executa a pesquisa
    Entao Produto pesquisado nao aparece na pagina de pesquisa
