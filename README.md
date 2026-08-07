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

- ✅ CRUD operations for Person entities
- ✅ RESTful API design
- ✅ Layered architecture (Controller → Service → Repository)
- ✅ Exception handling
- ✅ JPA/Hibernate integration
- ✅ Dependency Injection

---

## API Endpoints

| Method | Endpoint       |
| ------ | -------------- |
| GET    | `/person`      |
| GET    | `/person/{id}` |
| GET    | `/person/v1/{id}` |
| GET    | `/person/v2/{id}` |
| POST   | `/person`      |
| PUT    | `/person/{id}` |
| DELETE | `/person/{id}` |

### API Versioning

The versioned endpoints return different response contracts while keeping the
existing endpoint available:

- `GET /person/v1/{id}` returns the version 1 contract with `address`.
- `GET /person/v2/{id}` adds the `birthDay` field to the `address` contract.

The `birthDay` value in version 2 is generated for the response and is not
stored in the database.

### Example Request

```json
{
  "firstName": "Arthur",
  "lastName": "da Silva Mendes de Almeida",
  "adress": "Rua A, 123 - Bahia, Brasil",
  "gender": "Male"
}
```

### Example Response

```json
{
  "id": 1,
  "firstName": "Arthur",
  "lastName": "da Silva Mendes de Almeida",
  "adress": "Rua A, 123 - Bahia, Brasil",
  "gender": "Male"
}
```
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

Configure the database through environment variables:

```bash
export DB_USERNAME=root
export DB_PASSWORD=your_password
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

- [ ] Bean Validation
- [ ] Spring Security + JWT
- [ ] Swagger / OpenAPI
- [ ] Unit Tests with JUnit
- [ ] Docker

---

## Author

**Arthur da Silva Mendes de Almeida** - IT student

- 🎓 Learning backend development with Java and Spring Boot
- 🔗 GitHub: [@thurdass](https://github.com/thurdass)
- 💼 LinkedIn: [View Profile](https://www.linkedin.com/in/arthur-almeida-643a833b1/)
