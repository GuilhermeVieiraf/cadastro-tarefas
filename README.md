# Cadastro de Tarefas

Projeto simples para gerenciar tarefas usando Spring Boot, com CRUD completo e boas práticas.

---

## Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web (REST Controllers)
- Spring Data JPA
- Hibernate
- H2 Database (banco em memória para testes)
- Jakarta Validation (`@NotBlank`, `@Size`, `@Future`, `@NotNull`)
- Maven
- UUID para identificadores únicos
- Lombok (opcional, mas não usado neste projeto)

---

## Estrutura do projeto

- **entity**: contém a classe `Task` que representa a entidade de tarefa no banco de dados.
- **dto**: contém o `TaskDTO`, que é usado para entrada e saída nas APIs, com validações.
- **repository**: interface que estende `JpaRepository` para manipular dados.
- **service**: classe com a lógica de negócio e operações CRUD.
- **controller**: expõe os endpoints REST para criar, listar, atualizar e deletar tarefas.

---

## Endpoints disponíveis

| Método | Endpoint         | Descrição              |
|--------|------------------|------------------------|
| POST   | /tasks/create    | Cria uma nova tarefa    |
| GET    | /tasks/list-tasks| Lista todas as tarefas  |
| PUT    | /tasks/{id}      | Atualiza uma tarefa     |
| DELETE | /tasks/{id}      | Deleta uma tarefa pelo ID|

---

## Validações aplicadas no DTO

- `@NotBlank`: para campos que não podem ser vazios (ex: título)
- `@Size`: define tamanho mínimo e máximo para strings
- `@Future`: a data de expiração deve ser futura
- `@NotNull`: campo não pode ser nulo

---

## Banco de dados

- Usamos H2 Database, que é um banco em memória, facilitando o desenvolvimento e testes.
- Configuração em `application.yml` para rodar o H2 sem necessidade de instalação adicional.

---

## Como rodar

1. Clone o repositório  
2. Importe no IntelliJ (ou sua IDE favorita) como projeto Maven  
3. Rode a aplicação Spring Boot (`main` na classe principal)  
4. Use o Postman ou outro cliente para testar os endpoints



