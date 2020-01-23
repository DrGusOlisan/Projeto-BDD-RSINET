# language: pt
# encode: utf-8
Funcionalidade: Acao de Cadastro de usuario
  Cadastra usuario no sistema.

  Cenario: Cadastrar novo usuario com sucesso
    Dado Usuario esta na pagina principal
    Quando Usuario navega para a pagina de cadastro
    E Usuario preenche o formulario de cadastro
    Entao Usuario conclui o cadastro logado no sistema

  Cenario: Cadastrar usuario existente
    Dado Usuario esta na pagina principal
    Quando Usuario navega para a pagina de cadastro
    E Usuario preenche o formulario de cadastro
    Entao Mostra mensagem usuario ja existente
