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

## Microservices Structure

This repository is organized as **three Spring Boot services** (microservice-style layout):

1) **Service Registry (Eureka Server)**
   - Path: `ServiceRegistry/`
   - Port: `8761`
   - Config: `ServiceRegistry/src/main/resources/application.yaml`

2) **API Gateway (Spring Cloud Gateway)**
   - Path: `ApiGateway/`
   - Port: `9090`
   - Config: `ApiGateway/src/main/resources/application.yaml`
   - Routes:
     - `/auth/**` → `lb://QUANTITY-SERVICE`
     - `/api/**` → `lb://QUANTITY-SERVICE`
     - Swagger paths (`/swagger-ui/**`, `/swagger-ui.html`, `/v3/api-docs/**`) → `lb://QUANTITY-SERVICE`

3) **Quantity Service (Business Service)**
   - Path: `QuantityMeasurementApp/`
   - Port: `8081`
   - Config: `QuantityMeasurementApp/src/main/resources/application.yml`
   - Registers to Eureka as: `QUANTITY-SERVICE`

### Startup order (local / server)

1. Start **ServiceRegistry** (Eureka) on `8761`
2. Start **QuantityMeasurementApp** on `8081` (registers into Eureka)
3. Start **ApiGateway** on `9090` (routes traffic via Eureka using `lb://...`)

---

## CI/CD Structure (GitHub Actions)

This repo includes a deployment workflow:

- Workflow file: `.github/workflows/deploy.yml`
- Trigger: **push to `main`**
- Job: Connects to an EC2 instance via SSH and performs deployment steps.

### What the deploy workflow does

1) **SSH into EC2** using secrets:
- `EC2_HOST`
- `EC2_USER`
- `EC2_SSH_KEY`

2) **Pull latest code**
- Goes to: `~/QMA-Micro`
- Runs `git fetch origin`
- Hard resets to `origin/main`
- Cleans untracked files (`git clean -fd`)

3) **Stops old running services**
- Kills processes matching:
  - `ServiceRegistry`
  - `QuantityMeasurementApp`
  - `ApiGateway`

4) **Builds and starts all services (Maven wrapper)**
- Ensures `mvnw` is executable
- Removes old `target/` folders
- Creates log directory `~/logs`
- Builds and starts in this order:
  1. `ServiceRegistry` → runs on **8761**, logs: `~/logs/service-registry.log`
  2. `QuantityMeasurementApp` → runs on **8081**, logs: `~/logs/quantity-app.log`
  3. `ApiGateway` → runs on **9090**, logs: `~/logs/api-gateway.log`

5) **Verification output**
- Prints running Java processes
- Prints listening ports (`8761`, `8081`, `9090`)
- Lists log files under `~/logs/`

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
