# Quantity Measurement App

A Spring Boot backend that provides **quantity measurement operations** (comparison, conversion, arithmetic) across multiple measurement categories (e.g., **length**, **temperature**, etc.) and includes **JWT-based authentication** with **Spring Security**, backed by **PostgreSQL** via **Spring Data JPA**.

---

## Tech Stack

- **Java 17**
- **Spring Boot** (Web, Security, Data JPA)
- **PostgreSQL** (runtime DB)
- **JWT** (`io.jsonwebtoken:jjwt-*`)
- **Maven**
- **Lombok**

---

## Project Structure (high level)

Typical packages you’ll find under `src/main/java/com/example/quantitymeasurementapp`:

- `controller/` — REST endpoints (e.g., authentication endpoints)
- `service/` — business logic (e.g., auth service, measurement logic)
- `domain/` — core domain types (e.g., generic `Quantity`)
- `unit/` — unit definitions + conversions (e.g., `LengthUnit`, `TemperatureUnit`, etc.)
- `entity/` — database entities (e.g., `User`)
- `repository/` — Spring Data repositories (e.g., `UserRepository`)
- `security/` — JWT utilities + Security filter chain config
- `exception/` — centralized exception handling (`GlobalExceptionHandler`)

---

## Features

### Measurement / Quantity module
- Generic `Quantity<U extends IMeasurable>` domain model
- Unit conversion via `IMeasurable` contract
- Supports arithmetic (like add/subtract/divide) with validations (category-safe ops)

### Authentication / Security
- Signup/Login APIs under `/auth/**`
- JWT generation & validation (`AuthUtil`)
- Stateless authentication with Spring Security filter chain
- Protected routes under `/api/**` (requires valid JWT)

---

## Getting Started

### Prerequisites
- Java **17**
- Maven (or use the included Maven wrapper `./mvnw`)
- PostgreSQL running locally (or accessible remotely)

### Configure Database
Create/update your Spring config (usually `src/main/resources/application.properties`) with your PostgreSQL connection details, for example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/<db_name>
spring.datasource.username=<db_user>
spring.datasource.password=<db_password>

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> If `application.properties` isn’t present yet, add it under `src/main/resources/`.

---

## Run the Application

Using Maven wrapper:

```bash
./mvnw spring-boot:run
```

Or using Maven:

```bash
mvn spring-boot:run
```

---

## Run Tests

```bash
./mvnw test
```

(or `mvn test`)

---

## API Overview

### Auth endpoints (public)
Base path: `/auth/`

- `POST /auth/login`  
  Request: username + password  
  Response: JWT token + user details (based on your DTOs)

- `POST /auth/signup`  
  Request: username + password  
  Response: created user info

### Protected endpoints
- Routes under `/api/**` require `Authorization: Bearer <token>`

---

## Branches / Use-cases

This repo includes multiple feature branches that appear to be organized by incremental “UC” (use case) steps, for example:

- `feature/UC1-FeetEquality`
- `feature/UC5-UnitConversion`
- `feature/UC9-Weight-Measurement`
- `feature/UC14-Temprature-Measurement`
- `feature/UC17-Spring-Backend-Quantity-Measurement`
- `feature/UC18-Spring-Backend-Security`
- `dev`
- `main`

Each branch likely adds a new capability (new units/categories, arithmetic logic, architecture layering, DB integration, Spring backend, security, etc.).

---
