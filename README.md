# TechFlow Solutions - Sistema de Gerenciamento de Tarefas Logísticas

## Sobre o Projeto
Este projeto consiste em um sistema dinâmico de gerenciamento de tarefas desenvolvido sob medida para uma startup de logística. O objetivo principal é permitir o acompanhamento do fluxo de trabalho operacional em tempo real, auxiliando na priorização de entregas críticas, despacho de cargas e monitoramento da eficiência das equipes de distribuição.

O sistema conta com uma arquitetura backend robusta e uma interface gráfica amigável para facilitar o uso no dia a dia operacional.

---

## Escopo Inicial do Sistema
A versão inicial da aplicação contempla as seguintes funcionalidades essenciais (CRUD):
* **Cadastro de Tarefas Logísticas:** Registro de novas demandas com título, descrição, nível de prioridade e status.
* **Listagem em Tempo Real:** Visualização centralizada de todas as operações pendentes e em execução.
* **Atualização de Status:** Permite atualizar a fase de uma tarefa à medida que a entrega avança.
* **Exclusão de Registros:** Remoção de tarefas canceladas ou concluídas do painel ativo.

---

## Tecnologias e Ferramentas Utilizadas
* **Linguagem Principal:** Java 17+
* **Framework:** Spring Boot (Spring Web, Spring Data JPA, Validation)
* **Motor de Templates:** Thymeleaf (Renderização do lado do servidor)
* **Estilização Visual:** Bootstrap 5 (via CDN)
* **Banco de Dados:** MySQL
* **Gerenciador de Dependências:** Maven
* **Controle de Qualidade:** JUnit 5 e Mockito (Testes automatizados)
* **CI/CD:** GitHub Actions (Pipeline automatizado)

---

## Metodologia Adotada
O desenvolvimento deste projeto foi estruturado utilizando **Metodologias Ágeis**, combinando conceitos do **Scrum** e do **Kanban**:
* **Kanban:** Utilizado através da aba *Projects* do GitHub para gerenciar visualmente o fluxo das tarefas em tempo real, dividido estritamente entre as colunas **A Fazer**, **Em Progresso** e **Concluído**.
* **Iteração Rápida:** Foco na entrega contínua de software funcional, garantindo que mudanças de escopo possam ser assimiladas e rastreadas sem impactar negativamente o cronograma geral.