-----

### 📚 API de Lista de Tarefas com Spring Boot

-----

### 📋 Sobre o Projeto

Este é um projeto de estudo que implementa uma **API RESTful** completa para gerenciar uma lista de tarefas. Foi meu primeiro contato com o **Spring Boot**, servindo para demonstrar a criação de um **CRUD (Create, Read, Update, Delete)** e a exposição de endpoints para manipulação de dados.

Apesar de ser um projeto inicial, ele mostra a base de como construir uma API funcional e como os componentes do Spring (Controller, Repository e Model) interagem para criar uma aplicação coesa.

-----

### 🚀 Funcionalidades da API

A API permite realizar as seguintes operações na entidade `Tarefa`:

  * **Criação:** `POST /api/tarefas`
  * **Listagem:** `GET /api/tarefas`
  * **Busca por ID:** `GET /api/tarefas/{id}`
  * **Atualização:** `PUT /api/tarefas/{id}`
  * **Exclusão:** `DELETE /api/tarefas/{id}`

-----

### 💻 Tecnologias Utilizadas

  * **Java 17:** Linguagem de programação.
  * **Spring Boot:** Framework para o desenvolvimento rápido de aplicações.
  * **Spring Data JPA:** Simplifica a interação com o banco de dados.
  * **Hibernate:** Implementação da especificação JPA.
  * **Banco de Dados H2:** Banco de dados em memória, ideal para desenvolvimento e testes.
  * **Maven:** Gerenciador de dependências.

-----

### 🛠️ Como Executar o Projeto

1.  **Pré-requisitos:**

      * Java JDK 17 ou superior.
      * Uma IDE (como STS, IntelliJ, VS Code ou Eclipse).

2.  **Clone o repositório:**

    ```bash
    git clone https://github.com/marcosarantesj/spring-boot-todo-api.git
    ```

3.  **Abra e execute:**

      * Importe o projeto Maven na sua IDE e execute a classe principal `ListaTarefasApplication.java`.
      * A aplicação será iniciada e a API estará disponível em `http://localhost:8080`.

**Observação:** O banco de dados **H2** é em memória. Isso significa que todos os dados serão apagados a cada reinício da aplicação. O console do H2 pode ser acessado em `http://localhost:8080/h2-console` usando as credenciais do seu `application.properties`.
