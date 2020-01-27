# language: pt
# encode: utf-8
Funcionalidade: Acao de Cadastro de usuario
  Cadastra usuario no sistema.

  Contexto: 
    Dado Usuario esta na pagina principal
    Quando Usuario clica no botao de login
    E clica no botao de criar nova conta
    E preenche o formulario de cadastro
    E clica no botao de concordar com os termos
    E submete para cadastrar

  @CenarioCadastroPositivo
  Cenario: Cadastrar novo usuario com sucesso
    Entao Usuario conclui o cadastro logado no sistema

  @CenarioCadastroNegativo
  Cenario: Cadastrar usuario existente
    Entao Mostra mensagem usuario ja existente
