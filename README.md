# Spring Boot Lab

![img.png](img.png)

[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/)

A personal project I use to study Java and Spring Boot.

It started as a simple CRUD API for a Person entity connected to MySQL. As I learn new backend concepts, I add them to the project and improve the existing code.

The project is still in development and will continue evolving as I study new technologies and concepts.

Technologies
Java 21
Spring Boot 3.4
Spring Data JPA
MySQL
Maven
Dozer
Features
CRUD operations for Person
Layered architecture
Request and response DTOs
Bean Validation
Exception handling
Object mapping with Dozer and custom mappers
API versioning with v1 and v2
MySQL persistence with JPA
API Endpoints
Method	Endpoint	Description
GET	/person	Find all people
GET	/person/{id}	Find a person by ID
GET	/person/v1/{id}	Find a person using the v1 response
GET	/person/v2/{id}	Find a person using the v2 response
POST	/person	Create a person
PUT	/person/{id}	Update a person
DELETE	/person/{id}	Delete a person

For requests with a JSON body:

Content-Type: application/json
Examples
Create a person
POST http://localhost:8080/person
{
"firstName": "Arthur",
"lastName": "Almeida",
"adress": "Rua A, 123 - Bahia, Brasil",
"gender": "Male"
}
Update a person
PUT http://localhost:8080/person/1
{
"firstName": "Arthur",
"lastName": "Almeida",
"adress": "Rua B, 456 - Bahia, Brasil",
"gender": "Male"
}
API Versioning

The project also includes API versioning to practice working with different response contracts.

For now, versioning is available on the find-by-ID endpoint.

Version 1
GET http://localhost:8080/person/v1/1

Example response:

{
"id": 1,
"firstName": "Arthur",
"lastName": "Almeida",
"address": "Rua A, 123 - Bahia, Brasil",
"gender": "Male"
}
Version 2
GET http://localhost:8080/person/v2/1

Version 2 adds the birthDay field to the response:

{
"id": 1,
"firstName": "Arthur",
"lastName": "Almeida",
"address": "Rua A, 123 - Bahia, Brasil",
"gender": "Male",
"birthDay": "2026-08-07T00:00:00.000+00:00"
}
Project Structure
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
├── mapper
│   └── custom
│       └── PersonMapper.java
├── model
├── repository
└── services
Running the Project
Clone the repository
git clone https://github.com/thurdass/springboot-lab.git
cd springboot-lab
Configure MySQL

Create the database:

CREATE DATABASE springboot_lab;

Set your database credentials using environment variables:

export DB_USERNAME=root
export DB_PASSWORD=your_password

Make sure MySQL is running before starting the application.

Start the application
mvn spring-boot:run

The API will be available at:

http://localhost:8080
Run Tests
mvn test
Next Steps

Spring Security + JWT

Swagger / OpenAPI

Unit and integration tests

Docker

Add versioning to create and update endpoints

## Author

**Arthur da Silva Mendes de Almeida** - IT student

- 🎓 Learning backend development with Java and Spring Boot
- 🔗 GitHub: [@thurdass](https://github.com/thurdass)
- 💼 LinkedIn: [View Profile](https://www.linkedin.com/in/arthur-almeida-643a833b1/)
