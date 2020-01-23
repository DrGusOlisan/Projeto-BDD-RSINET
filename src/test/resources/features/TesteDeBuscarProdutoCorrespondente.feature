# language: pt
# encode: utf-8
Funcionalidade: Acao de selecao de produto
  Valida correspondencia do produto na pagina do produto com o produto encontrado na pagina principal.

  Cenario: Validar produto correspondente ao selecionado
    Dado Usuario esta na pagina principal
    Quando Usuario navega para os produtos populares
    E Usuario clica no primeiro produto
    Entao Produto correspondente aparece na pagina do produto

  Cenario: Validar produto nao correspondente ao selecionado
    Dado Usuario esta na pagina principal
    Quando Usuario navega para os produtos populares
    E Usuario clica no segundo produto
    Entao Produto nao correspondente aparece na pagina do produto
