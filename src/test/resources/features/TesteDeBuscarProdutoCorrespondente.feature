# language: pt
# encode: utf-8
Funcionalidade: Acao de selecao de produto
  Valida correspondencia do produto na pagina do produto com o produto encontrado na pagina principal.

  Contexto: 
    Dado Usuario esta na pagina principal
    Quando Usuario navega para os produtos populares

  @CenarioBuscaPositivo
  Cenario: Validar produto correspondente ao selecionado
    E Usuario clica no primeiro produto
    Entao Produto correspondente aparece na pagina do produto

  @CenarioBuscaNegativo
  Cenario: Validar produto nao correspondente ao selecionado
    E Usuario clica no segundo produto
    Entao Produto nao correspondente aparece na pagina do produto
