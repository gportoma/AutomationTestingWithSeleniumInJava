# Automação com Selenium e Java

Este repositório contém um projeto de automação de testes para o site Automation Testing Demo utilizando Java e
Selenium. O projeto é estruturado para facilitar a automação em diferentes partes do site, utilizando o Maven para
gerenciamento de dependências e o JUnit para execução dos testes.

## 📂 Estrutura do Projeto

A estrutura de diretórios do projeto é a seguinte:

````
└──projeto-automacao-selenium-java/
   └──src/
      ├──main/
      │   └──resources/
      │      └── config.yaml (Configura o path do ChromeDriver)
      └──test/
         └──java/
            ├─core/ (Classes importantes como BasePage, DriverFactory, DSL)
            ├─page/ (Classes para cada página com elementos web e lógicas)
            ├─runner/ (Classe para executar a automação com JUnit)
            └──util/ (Classe de apoio para ler o config.yaml)
````

## ⚙️ Configuração

1. Clone o repositório para sua máquina local.
2. Certifique-se de ter o Java e o Maven instalados.
3. Atualize o arquivo `config.yaml` com o caminho correto para o ChromeDriver em sua máquina.

## 🚀 Executando os Testes

Para executar os testes, navegue até a pasta raiz do projeto no terminal e execute o comando:

```bash
mvn test
```

Os testes automatizados incluem:

1. Preenchimento e envio do formulário de registro.
2. Escrita dentro de um frame.
3. Inserção de data de nascimento nos campos do DatePicker.
4. Movimentação do slider para 50%.