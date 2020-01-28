# Projeto-BDD-RSINET
Projeto BDD

  Pasta src/main/java
  
    pacote br.com.rsinet.hub_bdd.cucumber
      ContextoDeCenario -> Classe utilizada para manipular um certo valor entre classes.
      ContextoDeTeste -> Classe utilizada para controlar as instâncias dos objetos criados.
    
    pacote br.com.rsinet.hub_bdd.dadosParaTeste
      DadosParaTeste.xlsx -> Arquivo em Excel para ser consumida como massa de dados
    
    pacote br.com.rsinet.hub_bdd.enums
      Contexto -> Enum utilizado no ContextoDeCenario.
    
    pacote br.com.rsinet.hub_bdd.gerenciadores
      LeitorDeConfigsManager -> Classe que gerencia a instância de um objeto LeitorDeConfigs.
      PageObjectManager -> Classe que gerencia a instância de objetos PageObjectFactory.
      WebDriverManager -> Classe que gerencia a instância de objetos WebDriver.
      
    pacote br.com.rsinet.hub_bdd.pageObjectFactory (Pacote com classes criadas seguindo o design pattern PageObjectFactory)
      HomePage_POF -> Classe utilizada para armazenar elementos e ações da página principal da aplicação WEB.
      LoginPage_POF -> Classe utilizada para armazenar elementos e ações da página de login da aplicação WEB.
      ProductPage_POF -> Classe utilizada para armazenar elementos e ações da página do produto da aplicação WEB.
      RegisterPage_POF -> Classe utilizada para armazenar elementos e ações da página de cadastro da aplicação WEB.
      SearchPage_POF -> Classe utilizada para armazenar elementos e ações da página de pesquisa de produtos da aplicação WEB.
    
    pacote br.com.rsinet.hub_bdd.provedorDeDados
      LeitorDeConfigs -> Classe utilizada para ler o arquivo configuracoes.properties.
      
    pacote br.com.rsinet.hub_bdd.utils
      ExcelUtils -> Classe utilizada para ler a massa de dados de arquivos Excel.
      MassaDeDados -> Classe utilizada para consumir a massa de dados e organiza-las para utilizar no código.
    
  pasta src/test/java
  
    pacote br.com.rsinet.hub_bdd.runner
      TestRunner -> Classe utilizada para rodar os testes.
    
    pacote br.com.rsinet.hub_bdd.stepDefinitions
      HomePageSteps -> Classe utilizada para implementar os passos de testes relacionados a pagina principal da aplicação web.
      Hooks -> Classe utilizada para implementar os hooks After e Before do cucumber, para rodarem antes e depois de cada teste.
      ProductPageSteps -> Classe utilizada para implementar os passos de testes relacionados a pagina do produto da aplicação web.
      RegisterPageSteps -> Classe utilizada para implementar os passos de testes relacionados a pagina de cadastro da aplicação web.
      SearchPageSteps -> Classe utilizada para implementar os passos de testes relacionados a pagina de pesquisa dos produtos da aplicação web.
  
  pasta src/test/resources
  
    pacote features
      PesquisarProduto -> Feature cucumber com a história de cenarios de teste relacionado a pesquisa de produtos pelo campo de pesquisa.
      TesteDeBuscarProdutoCorrespondente -> Feature cucumber com a história de cenarios de teste relacionado a pesquisa de produtos pela pagina principal.
      TesteDeCadastrarUsuario -> Feature cucumber com a história de cenarios de teste relacionado a cadastrar usuarios.
