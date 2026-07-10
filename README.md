# WorkFlow Manager

O **WorkFlow Manager** é um sistema de gerenciamento de fluxo de trabalho baseado em um quadro Kanban, desenvolvido para otimizar o acompanhamento de demandas e rotas em operações de logística.

Este projeto foi construído utilizando a arquitetura em camadas do ecossistema Spring Boot, integrando persistência em banco de dados relacional, automação de testes e uma esteira de integração contínua.

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3.x**
    * Spring Data JPA (Persistência de dados e mapeamento ORM)
    * Spring Web (Gerenciamento de rotas HTTP e MVC)
    * Thymeleaf (Motor de renderização dinâmica para o Frontend)
* **Lombok** (Produtividade e encapsulamento de código limpo)
* **MySQL** (Banco de dados relacional)
* **Bootstrap 5** (Estilização moderna e responsividade da interface visual)
* **JUnit 5 & Mockito** (Testes unitários e isolamento de dependências)
* **GitHub Actions** (Esteira de Integração Contínua - CI)

## Arquitetura do Projeto

O sistema segue o padrão de arquitetura em camadas para garantir a separação de responsabilidades e facilidade de manutenção:
* `model`: Mapeamento das entidades do banco de dados (`Tarefa`).
* `repository`: Interfaces de comunicação direta e consultas ao banco via Spring Data JPA.
* `service`: Camada central contendo as regras de negócio do sistema.
* `controller`: Gerenciamento das requisições HTTP, rotas do Kanban e envio de dados para a View.
* `templates`: Páginas HTML estruturadas dinamicamente com Thymeleaf (`kanban.html`).

## Integração Contínua (CI)

O projeto possui um pipeline de CI configurado via **GitHub Actions** (`.github/workflows/ci.yml`). A cada `push` ou `pull request` realizado nas ramificações principais, uma esteira automatizada em nuvem é disparada para:
1. Provisionar um ambiente isolado com Ubuntu e JDK 21.
2. Resolver e baixar as dependências do projeto através do Maven.
3. Executar de forma limpa a suíte de testes automatizados (`mvn test`).

## Testes Unitários

A aplicação conta com testes unitários automatizados para garantir a robustez das regras de negócio na camada de serviço (`TarefaService`), utilizando o **Mockito** para simular o comportamento do repositório:
* Teste de criação e salvamento de fluxos de trabalho com sucesso.
* Teste de filtragem e listagem de demandas por status de coluna do Kanban.

## Como Executar o Projeto

1. Certifique-se de ter o **MySQL** rodando localmente no seu ambiente.
2. Configure as credenciais do seu banco de dados no arquivo `src/main/resources/application.properties`.
3. Abra o projeto em sua IDE (IntelliJ IDEA) e execute a classe principal `WorkflowManagerApplication`.
4. Acesse o painel de logística no seu navegador através do endereço: `http://localhost:8080/tarefas`.