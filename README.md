# Spring Boot Lab

![Project preview](img.png)

<p align="center">

<img src="https://skillicons.dev/icons?i=java,spring,mysql,maven" />

</p>
A personal project for studying Java and Spring Boot through the development of a REST API.

The project started as a simple CRUD API for a `Person` entity connected to MySQL. It evolves as new backend concepts are studied and added to the application.

## Contents

- [Technologies](#technologies)
- [Features](#features)
- [API endpoints](#api-endpoints)
- [API versioning](#api-versioning)
- [Project structure](#project-structure)
- [Getting started](#getting-started)
- [Tests](#tests)
- [Next steps](#next-steps)
- [Author](#author)

## Technologies

- Java 21
- Spring Boot 3.4.0
- Spring Web
- Spring Data JPA
- Bean Validation
- MySQL
- Maven
- Dozer

## Features

- CRUD operations for people
- Layered architecture
- Request and response DTOs
- Bean validation
- Exception handling
- Object mapping with Dozer and custom mappers
- API versioning with v1 and v2 response contracts
- MySQL persistence with JPA

## API endpoints

The API runs by default at `http://localhost:8080`.

| Method | Endpoint | Description |
| --- | --- | --- |
| `GET` | `/person` | Find all people |
| `GET` | `/person/{id}` | Find a person by ID |
| `GET` | `/person/v1/{id}` | Find a person using the v1 response |
| `GET` | `/person/v2/{id}` | Find a person using the v2 response |
| `POST` | `/person` | Create a person |
| `PUT` | `/person/{id}` | Update a person |
| `DELETE` | `/person/{id}` | Delete a person |

Requests with a body must use the following header:

```http
Content-Type: application/json
```

### Create a person

```http
POST http://localhost:8080/person
```

```json
{
  "firstName": "Arthur",
  "lastName": "Almeida",
  "adress": "Rua A, 123 - Bahia, Brasil",
  "gender": "Male"
}
```

> Note: the request DTO currently exposes `adress` with this spelling. Response DTOs use `address`.

### Update a person

```http
PUT http://localhost:8080/person/1
```

```json
{
  "firstName": "Arthur",
  "lastName": "Almeida",
  "adress": "Rua B, 456 - Bahia, Brasil",
  "gender": "Male"
}
```

## API versioning

Versioning is currently available on the find-by-ID endpoint and demonstrates how different response contracts can coexist.

### Version 1

```http
GET http://localhost:8080/person/v1/1
```

```json
{
  "id": 1,
  "firstName": "Arthur",
  "lastName": "Almeida",
  "address": "Rua A, 123 - Bahia, Brasil",
  "gender": "Male"
}
```

### Version 2

```http
GET http://localhost:8080/person/v2/1
```

Version 2 adds the `birthDay` field:

```json
{
  "id": 1,
  "firstName": "Arthur",
  "lastName": "Almeida",
  "address": "Rua A, 123 - Bahia, Brasil",
  "gender": "Male",
  "birthDay": "2026-08-07T00:00:00.000+00:00"
}
```

## Project structure

```text
src/main/java/com/thurdass/springboot_lab
├── config
│   └── DozerConfig.java
├── controllers
│   ├── PersonController.java
│   └── TestLogController.java
├── dto
│   ├── PersonRequest.java
│   ├── PersonResponse.java
│   ├── v1
│   │   └── PersonDTO.java
│   └── v2
│       └── PersonDTOV2.java
├── exception
│   ├── ExceptionResponse.java
│   ├── ResourceNotFoundException.java
│   └── handler
│       └── customEntityResponseHandler.java
├── mapper
│   └── custom
│       └── PersonMapper.java
├── model
├── repository
└── services
```

## Getting started

### Prerequisites

- Java 21
- Maven
- MySQL

### 1. Clone the repository

```bash
git clone https://github.com/thurdass/springboot-lab.git
cd springboot-lab
```

### 2. Create the database

```sql
CREATE DATABASE springboot_lab;
```

### 3. Configure the database

The application reads the database credentials from environment variables. Defaults are available for local development, but setting both variables is recommended:

```bash
export DB_USERNAME=root
export DB_PASSWORD=your_password
```

Make sure MySQL is running before starting the application.

### 4. Start the application

```bash
mvn spring-boot:run
```

The API will be available at [http://localhost:8080](http://localhost:8080).

## Tests

Run the test suite with:

```bash
mvn test
```

## Next steps

- Add Spring Security with JWT
- Add Swagger/OpenAPI documentation
- Expand unit and integration tests
- Add Docker support
- Add versioning to create and update endpoints

## Author

**Arthur da Silva Mendes de Almeida** — IT student

- Learning backend development with Java and Spring Boot
- GitHub: [@thurdass](https://github.com/thurdass)
- LinkedIn: [View profile](https://www.linkedin.com/in/arthur-almeida-643a833b1/)
