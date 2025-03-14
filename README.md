# UserManagement - API de Gerenciamento de Usuários

## Contexto

TechManage é uma API RESTful desenvolvida em Spring Boot para gerenciar usuários, permitindo criar, buscar, atualizar e excluir registros. O projeto foi criado como parte de um desafio técnico e implementa boas práticas de desenvolvimento, validação e persistência de dados em um banco de dados relacional.

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA**
- **Hibernate**
- **Banco de dados relacional (MySQL, PostgreSQL ou H2)**
- **Lombok**
- **Bean Validation**
- **JUnit e Mockito (para testes)**
- **Swagger/OpenAPI (para documentação da API)**

---

## Funcionalidades

A API oferece os seguintes endpoints:

### Criar um novo usuário
**POST** `/api/users`
- Requisição:
```json
{
  "fullName": "João Silva",
  "email": "joao.silva@email.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "ADMIN"
}
```
- Resposta:
```json
{
  "id": 1,
  "fullName": "João Silva",
  "email": "joao.silva@email.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "ADMIN"
}
```

### Buscar todos os usuários
**GET** `/api/users`
- Resposta:
```json
[
  {
    "id": 1,
    "fullName": "João Silva",
    "email": "joao.silva@email.com",
    "phone": "+55 11 99999-9999",
    "birthDate": "1990-05-15",
    "userType": "ADMIN"
  }
]
```

### Buscar um usuário por ID
**GET** `/api/users/{id}`
- Resposta:
```json
{
  "id": 1,
  "fullName": "João Silva",
  "email": "joao.silva@email.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "ADMIN"
}
```
- Se o ID não for encontrado:
```json
{
  "error": "Usuário não encontrado"
}
```

### Atualizar um usuário
**PUT** `/api/users/{id}`
- Requisição:
```json
{
  "fullName": "João Silva Souza",
  "email": "joao.silva@email.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "EDITOR"
}
```
- Resposta:
```json
{
  "id": 1,
  "fullName": "João Silva Souza",
  "email": "joao.silva@email.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "EDITOR"
}
```

### Excluir um usuário
**DELETE** `/api/users/{id}`
- Resposta:
```json
{
  "message": "Usuário deletado com sucesso"
}
```
- Se o ID não for encontrado:
```json
{
  "error": "Usuário não encontrado"
}
```

---

## Validações Implementadas

- **Email único e válido**
- **Nome completo obrigatório**
- **Telefone no formato internacional**
- **Data de nascimento válida**
- **Enum para tipo de usuário (ADMIN, EDITOR, VIEWER)**

---

## Como Rodar o Projeto Localmente
## Contato

Dúvidas ou sugestões? Entre em contato via github


1. Clone o repositório:
   ```sh
   git clone https://github.com/italoaraujosantos/usermanagement.git
   cd TechManage
   ```
2. Configure o banco de dados no arquivo `application.properties` ou `application.yml`.
3. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```
4. Acesse a documentação da API via Swagger:
   - [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Testes

- Rode os testes unitários com:
  ```sh
  mvn test
  ```
- Os testes cobrem:
  - Validações da entidade User
  - Regras de negócio no service
## Contato

Dúvidas ou sugestões? Entre em contato via [seu email ou LinkedIn].

  - Testes de integração dos endpoints

---

## Estrutura do Projeto
```
UserManagement/
├── src/
│   ├── main/
│   │   ├── java/com/example/techmanage/
│   │   │   ├── controllers/
│   │   │   ├── services/
│   │   │   ├── repositorys/
│   │   │   ├── entities/
│   │   │   ├── dto/
│   │   │   ├── exceptions/
│   │   │   ├── UserManagementApplication.java
│   ├── test/
│       ├── java/com/example/usermanagement/
│       │   ├── service/
│       │   ├── controller/
├── pom.xml
├── README.md
```

---

## Contribuição

Fique à vontade para abrir issues e pull requests no repositório!

---

## Contato

Dúvidas ou sugestões? Entre em contato via [seu email ou LinkedIn].

**Autor:** Ítalo Araujo  
**Repositório:** [GitHub - TechManage](https://github.com/italoaraujosantos/usermanagement)


