# Spring Boot Lab

<div align="center">

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)

<img src="https://github.com/user-attachments/assets/32edacaf-06a5-442d-97e5-ba8d47715004" alt="Spring Boot" width="200" />


Backend REST API built with Java, Spring Boot and MySQL for learning and practicing backend development concepts.

</div>

---

## About

This repository contains my studies and experiments with Spring Boot.

The current project is a REST API built with Java and Spring Boot, implementing CRUD operations for a Person entity. The goal is to practice backend development concepts such as layered architecture, RESTful APIs, dependency injection, exception handling, and database integration with JPA.

---

## Technologies

* Java 21
* Spring Boot 3.4
* Spring Data JPA
* MySQL
* Maven

---

## Features

* CRUD operations for Person entities
* RESTful API design
* Layered architecture (Controller → Service → Repository)
* Exception handling
* JPA/Hibernate integration
* Dependency Injection

---

## API Endpoints

| Method | Endpoint       |
| ------ | -------------- |
| GET    | `/person`      |
| GET    | `/person/{id}` |
| POST   | `/person`      |
| PUT    | `/person`      |
| DELETE | `/person/{id}` |

### Example Request

```json
{
  "firstName": "Arthur",
  "lastName": "da Silva Mendes de Almeida"
  "address": "Rua A, Bahia",
  "gender": "Male"
}
```

### Example Response

```json
{
   "firstName": "Arthur",
   "lastName": "da Silva Mendes de Almeida"
   "address": "Rua A, Bahia",
   "gender": "Male"
}
```
<div align="center">

![Captura de tela de 2026-07-29 22-25-54.png](../../Imagens/Capturas%20de%20tela/Captura%20de%20tela%20de%202026-07-29%2022-25-54.png)
---

## Project Structure

```text
src/main/java/com/thurdass/springboot_lab
├── controllers
├── services
├── repository
├── model
└── exception
```

---

## Running the Project

### Clone the repository

```bash
git clone https://github.com/thurdass/springboot-lab.git
cd springboot-lab
```

### Configure the database

Edit the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/springboot_lab
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Run the application

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

---

## Next Steps

* Bean Validation
* Spring Security + JWT
* Swagger / OpenAPI
* Unit Tests with JUnit
* Docker

---

## Author

Arthur Almeida

* GitHub: https://github.com/thurdass
* LinkedIn: https://linkedin.com/in/thurdas](https://www.linkedin.com/in/arthur-almeida-643a833b1/
