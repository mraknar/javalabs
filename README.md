# Java Projects

This repository contains a collection of Java projects developed for learning and practicing core programming concepts.

## Table of Contents

1. [Java Console Calculator](#java-console-calculator)
2. [Java Number Guessing Game](#java-number-guessing-game)
3. [Java Stream Operations](#java-stream-operations)
4. [Spring Boot User API](#spring-boot-user-api)
5. ...


# [Java Console Calculator](calculator/)

This project is a simple **console-based calculator** developed using Java. It performs basic mathematical operations and includes features like storing the last result in memory for future use.

## Features

- Addition
- Subtraction
- Multiplication
- Division (with divide-by-zero check)
- Square root calculation
- Exponentiation
- Store result in memory
- Clear memory
- Use the value in memory by typing `m` as input


# [Java Number Guessing Game](Number%20Guessing%20Game/)

This project is a **console-based number guessing game** developed in Java. It challenges the user to guess a randomly selected number within a limited time and attempt count. The game includes difficulty modes, input validation, and dynamic hints based on the user's proximity to the correct number.

## Features

- Easy and Hard difficulty modes
- Random number generation
- Limited time and attempt count per game
- Hint system based on guess accuracy
- Input validation and error handling
- Option to replay or exit

## Game Modes

1. **Easy Mode**  
   - Number range: 0 to 100  
   - Time limit: 45 seconds  
   - Maximum attempts: 10  

2. **Hard Mode**  
   - Number range: 0 to 1000  
   - Time limit: 60 seconds  
   - Maximum attempts: 15  

## How to Play

1. Choose a difficulty mode when prompted.
2. Try to guess the random number within the time and attempt limits.
3. The game gives feedback based on how close your guess is to the target number.
4. When the game ends, you can choose to play again or exit.


# [Java Stream Operations](Stream%20API/)

This project demonstrates advanced usage of Java Streams to perform both **numerical** and **textual (alphabetical)** data processing tasks.

## Features

### Numerical Operations (1–100 Range)
- Count of numbers divisible by 4 and 8
- Count and sum of:
  - Odd numbers
  - Even numbers
  - Prime numbers
- Multiply all multiples of 3 by 2 and calculate the total sum

### Alphabetical Operations
- Count cities starting with the letter "A"
- Convert all city names to uppercase and sort them alphabetically (Turkish locale)
- Print cities with ≤5 letters in reverse alphabetical order
- Group cities by their name lengths


# [Spring Boot User API](springboot-user-api/)

This project is a basic user management RESTful API built using **Java Spring Boot**. It supports common CRUD operations like creating, listing, updating, and deleting users, and it integrates with a PostgreSQL database.

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Validation
- Hibernate ORM
- PostgreSQL
- MapStruct
- Lombok
- REST API
- Maven

## Topics Applied

During the development of this project, the following technologies and architectural concepts were applied:

- Spring Context and Bean Management
- Layered Architecture (Controller - Service - Repository - Entities)
- DTO (Data Transfer Object) Pattern
- Automatic mapping with MapStruct
- Validation
- ORM with JPA & Hibernate
- Database schema management & DDL errors
- RESTful API development
- Postman for API testing
- Dependency management

## Features

- Basic CRUD operations for `User` entity
- Clear separation between entity and DTO
- MapStruct for converting between Entity and DTO
- Validation of input using `@NotNull`, `@Size`, `@Email`, etc.
- Integration with PostgreSQL via Spring Data JPA
- Exception handling for invalid or missing data

## Example Endpoints

| Method | Endpoint           | Description               |
|--------|--------------------|---------------------------|
| GET    | `/users`           | Retrieve all users        |
| GET    | `/users/{id}`      | Get a user by ID          |
| POST   | `/create`          | Create a new user         |
| POST   | `/create/bulk`     | Create new users          |
| PUT    | `/update/{id}`     | Update an existing user   |
| DELETE | `/delete/{id}`     | Delete a user by ID       |




