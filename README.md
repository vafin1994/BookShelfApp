# BookShelfApp 📚

A full-stack book library application built for learning purposes. This project covers the fundamentals of modern web development with a Java backend and Angular frontend.

## Deploy
Deployed with ngrok, hosted locally 

Forwarding: https://unwary-freeness-return.ngrok-free.dev -> http://localhost:8080

## Tech Stack

**Backend**
- Java 21 (Temurin LTS)
- Spring Boot 4
- Spring Data JPA / Hibernate
- PostgreSQL

**Frontend**
- https://github.com/vafin1994/BookShelfApp-Frontend
- https://bookshelfapp-indol.vercel.app/

## Features

- Browse and search a book library
- Add, edit and delete books
- View book details (title, author, ISBN, genre, language, publishing year)

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.9+
- PostgreSQL

### Backend Setup

1. Clone the repository
   ```bash
   git clone https://github.com/vafin1994/BookShelfApp.git
   cd BookShelfApp
   ```

2. Create a PostgreSQL database
   ```sql
   CREATE DATABASE bookshelf;
   ```

3. Create `src/main/resources/application-local.properties` and add your credentials
   ```properties
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

4. Run the application
   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/books` | Get all books |
| GET | `/books/{id}` | Get a book by ID |
| POST | `/books` | Create a new book |
| PUT | `/books/{id}` | Update a book |
| DELETE | `/books/{id}` | Delete a book |

## Project Status

🚧 In active development — backend API in progress, Angular frontend coming next.