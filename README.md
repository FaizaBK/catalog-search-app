# CatalogSearchApp

## Overview

CatalogSearchApp is a Spring Boot application designed for managing seller SKUs  and profiles in an e-commerce environment. The application utilizes MongoDB as its database and provides RESTful APIs for creating, retrieving, updating, and deleting SKUs and profiles.

## Features

- Create, read, update, and delete Seller SKUs.
- Manage profiles associated with Seller SKUs.
- MongoDB integration for data persistence.
- Exception handling for better error management.
- Lombok for reducing boilerplate code.

## Technologies Used

- Java 21
- Spring Boot 3.3.5
- Spring Data MongoDB
- Lombok
- Maven
- JUnit 5 for testing

## Initialization

### Prerequisites

Make sure you have the following installed:

- Java 21
- Maven
- MongoDB

### Clone the Repository

```bash
git clone https://github.com/FaizaBK/catalogsearchapp.git
cd catalogsearchapp
```

## Configuration
**MongoDB connection configuration**: spring.data.mongodb.uri=mongodb://localhost:27017/ecommerceDB
**Spring Boot application settings**: 
- server.port=8080
- spring.application.name=catalogsearchapp

## Project Structure
```bash
catalogsearchapp/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── fr/
│   │   │       └── faizamnasry/
│   │   │           └── ecommerce/
│   │   │               ├── CatalogsearchappApplication.java
│   │   │               ├── controllers/
│   │   │               │   ├── ProfileController.java
│   │   │               │   └── SellerSKUController.java
│   │   │               ├── exceptions/
│   │   │               │   ├── GlobalExceptionHandler.java
│   │   │               │   ├── ProfileNotFoundException.java
│   │   │               │   └── SellerSKUNotFoundException.java
│   │   │               ├── models/
│   │   │               │   ├── EmbeddedBean.java
│   │   │               │   ├── Profile.java
│   │   │               │   └── SellerSKU.java
│   │   │               ├── repositories/
│   │   │               │   ├── ProfileRepository.java
│   │   │               │   └── SellerSKURepository.java
│   │   │               └── services/
│   │   │                   └── SellerSKUService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   │           └── (optional static files)
│   └── test/
│       └── java/
│           └── fr/
│               └── faizamnasry/
│                   └── ecommerce/
│                       └── CatalogsearchappApplicationTests.java
└── pom.xml

```
## API Endpoints
- Seller SKU Endpoints 
  - Create Seller SKU : POST /api/seller-skus/create/
  - Request Body: SKUProfileRequest : 
  - Get Seller SKUs by Profile : GET /api/seller-skus/{profileId}
  - Update Seller SKU : PUT /api/seller-skus/{skuId}
  - Request Body: SellerSKU
  - Remove Seller SKU :DELETE /api/seller-skus/{skuId}/{profileId}

- Profile Endpoints
  - Create Profile : POST /api/profiles/create/
  - Get Profile by Company Name : GET /api/profiles/{companyName}
## Dependencies
The project includes the following dependencies:

- Spring Boot Starter Data MongoDB: For MongoDB integration.
- Spring Boot Starter Validation: To enable validation features.
- Lombok: To reduce boilerplate code .
- Spring Boot Starter Test: For testing support.
- Spring Boot Starter Web: For building web applications, including RESTful services.
- Springdoc OpenAPI Webflux UI: For API documentation using OpenAPI.

## IDE Setup
This project was created using IntelliJ IDEA. You can import the project as a Maven project and start working with the various components directly in the IDE.
