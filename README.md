# Employee Management System (Spring Boot)

Backend API for employee CRUD with validation, JWT authentication, and role-based authorization.

## Features
- Employee CRUD APIs
- Request validation (`@Valid`) for create/update payloads
- Global structured error responses (404, 400 validation, 401, 500)
- JWT login endpoint (`/auth/login`)
- Role-based authorization:
  - `ADMIN`: full access
  - `HR`: create/update/read
  - `EMPLOYEE`: read-only
- Environment-based configuration
- Test profile using in-memory H2 database (no MySQL required for tests)

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (`jjwt`)
- MySQL (default runtime profile)
- H2 (local/test profile)
- Gradle

## Project Layout
- Backend: `employeemanagement`
- Frontend folder exists: `fullstack-front` (currently empty in this repo snapshot)

## Installation and Run

### 1. Prerequisites
- JDK 17+
- No manual Gradle install needed (wrapper is included)

### 2. Run with local in-memory DB (no MySQL installation needed)
```powershell
cd employeemanagement
.\gradlew.bat bootRun --args="--spring.profiles.active=local"
```

### 3. Run with MySQL (optional)
Set environment variables, then run:
```powershell
$env:DB_URL="jdbc:mysql://localhost:3306/fullstack?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"
$env:DB_USERNAME="root"
$env:DB_PASSWORD="your_password"
cd employeemanagement
.\gradlew.bat bootRun
```

## Default Auth Users
Credentials are configurable via env vars. Default values:
- `admin / admin123` -> role `ADMIN`
- `hr / hr123` -> role `HR`
- `employee / employee123` -> role `EMPLOYEE`

## API Security Flow
1. Login:
```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```
2. Use returned token:
```http
Authorization: Bearer <accessToken>
```

## API Endpoints
- `POST /auth/login` -> public
- `GET /users` -> `ADMIN`, `HR`, `EMPLOYEE`
- `GET /user/{id}` -> `ADMIN`, `HR`, `EMPLOYEE`
- `POST /user` -> `ADMIN`, `HR`
- `PUT /user/{id}` -> `ADMIN`, `HR`
- `DELETE /user/{id}` -> `ADMIN`

## Testing
Run:
```powershell
cd employeemanagement
.\gradlew.bat test
```
Tests use `application-test.properties` with H2 in-memory DB.

## Resume-Ready Highlights
- Implemented stateless JWT authentication and role-based access control using Spring Security.
- Added robust backend validation and centralized error handling for production-style API responses.
- Introduced profile-based configuration for local, test, and database-backed environments.
