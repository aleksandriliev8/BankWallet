# 🏦 Bank Wallet REST API

A secure, stateless RESTful API built with **Java 21** and **Spring Boot 4**. This application simulates a core banking system, allowing users to register, securely authenticate, manage digital wallets, and perform transactional financial operations.



## ✨ Architecture & Key Features
* **Stateless Security:** Implemented Custom JWT (JSON Web Token) authentication flow using Spring Security 7.
* **Role-Based Access Control (RBAC):** Distinct access levels for `USER` and `ADMIN` roles, secured via method-level security (`@PreAuthorize`).
* **ACID Transactions:** Financial operations (deposits, withdrawals, transfers) are secured with Spring's `@Transactional` to ensure data integrity.
* **Centralized Exception Handling:** Utilizes `@RestControllerAdvice` and custom `HandlerExceptionResolver` to catch and format both standard and Security/Filter-level exceptions into clean, consistent JSON responses.
* **Zero-Config Local Setup:** Integrated with a cloud-hosted Serverless PostgreSQL database (Neon), allowing reviewers to run and test the application instantly without local database configuration.

## 🛠️ Tech Stack
* **Core:** Java 21, Spring Boot 4.0.3
* **Security:** Spring Security 7, JWT (`io.jsonwebtoken`)
* **Persistence:** Spring Data JPA, Hibernate, PostgreSQL
* **Validation:** Hibernate Validator (Jakarta Bean Validation)
* **Build Tool:** Maven

---

## 🚀 Getting Started

To make the review process frictionless, the application is pre-configured to connect to a cloud development database. **No local PostgreSQL installation is required.**

### 1. Clone the repository
```bash
git clone https://github.com/aleksandriliev8/BankWallet
cd wallet-backend
```

### 2. Run the application
Ensure you have Java 21 installed. You can run the application directly via your IDE (execute BankWalletApplication.java) or via Maven:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```
The server will start on `http://localhost:8080`.

## 📖 API Documentation & Testing Guide
You can test the API using Postman, Insomnia, or any HTTP client.

### 1. Authentication Flow

**Register a New User**

   Creates a new user profile and automatically provisions an empty digital wallet.

**POST** /api/v1/users/register

```json
{
  "firstName": "Mr",
  "lastName": "User",
  "username": "mr_user",
  "email": "mruser@example.com",
  "password": "userpassword123",
  "age": 31,
  "role": "USER"
}
```
**Note:** Save the returned id (UUID) from the response, as it is required for wallet transactions.

**Login & Retrieve JWT**
  Authenticates the user and returns a Bearer token.
**POST** /api/v1/auth/login

```json
{
  "username": "mr_user",
  "password": "userpassword123"
}
```
**Important:** Copy the `token` string from the response. For all subsequent endpoints, include it in the Request Headers:
`Authorization: Bearer <YOUR_JWT_TOKEN>`

### 2. Financial Operations

**Deposit Funds**

**_(Requires Authorization Header)_**

**POST** `/api/v1/wallets/deposit`

```json
{
  "userId": "<YOUR_USER_UUID>",
  "amount": 1000.00
}
```

**Withdraw Funds**

**_(Requires Authorization Header)_**

**POST** `/api/v1/wallets/withdraw`

```json
{
  "userId": "<YOUR_USER_UUID>",
  "amount": 150.50
}
```

**Transfer Funds**

Transfer money between two registered users. Evaluates sufficient balance before executing.

**_(Requires Authorization Header)_**

**POST** `/api/v1/wallets/transfer`

```json
{
  "fromUserId": "<SENDER_UUID>",
  "toUserId": "<RECEIVER_UUID>",
  "amount": 250.00
}
```

### 3. Security Testing (RBAC)

**Admin Secret Endpoint**

Validates Role-Based Access Control. Accessible only if the registered user has the ADMIN role.

**GET** `/api/v1/admin/secret`

_**(Requires Authorization Header)**_

***

_Developed as a portfolio project demonstrating modern Spring Boot backend engineering practices._
