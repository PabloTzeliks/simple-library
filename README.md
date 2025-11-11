# Simple Library

A console-based library management system demonstrating modular Java architecture with MySQL database integration.

## Features

- **Book Management**: Register new books with title, author, year, and availability tracking
- **Loan System**: Register book loans with automatic availability control and due date validation
- **Return System**: Process book returns and restore availability
- **List Books**: View all registered books with their details and availability status
- **List Loans**: View all active loans with dates and associated books

## Technologies

- **Java 22**: Core application language with OOP principles
- **JDBC**: Database connectivity and operations
- **MySQL**: Relational database for data persistence
- **Maven**: Dependency management and build automation

## Architecture

The project follows a layered architecture with clear separation of concerns:

```
src/main/java/pablo/tzeliks/
├── model/              # Domain entities (Livro, Emprestimo)
├── service/            # Business logic (validation, orchestration)
├── infraestructure/    # Data access layer (repositories, DB connection)
├── view/               # Console UI (menus, input helpers)
└── Main.java           # Application entry point
```

**Design Patterns**:
- Repository Pattern for data access
- Dependency Injection for loose coupling
- Service Layer for business logic isolation

## Prerequisites

- JDK 22 or higher
- MySQL Server 8.0+
- Maven 3.6+

## Database Setup

Create the database and tables:

```sql
CREATE DATABASE sql_db;
USE sql_db;

CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    ano INT NOT NULL,
    disponivel BOOLEAN DEFAULT TRUE
);

CREATE TABLE emprestimos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    livro_id INT NOT NULL,
    data_emprestimo DATE NOT NULL,
    data_devolucao DATE NOT NULL,
    FOREIGN KEY (livro_id) REFERENCES livros(id)
);
```

Update database credentials in `src/main/java/pablo/tzeliks/infraestructure/Conn/Conexao.java`:

```java
private static final String URL = "jdbc:mysql://localhost:3306/sql_db";
private static final String User = "your_username";
private static final String Passwd = "your_password";
```

## Running the Application

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="pablo.tzeliks.Main"
```

## Usage

The application provides an interactive console menu:

1. **Register Book**: Add new books to the library
2. **Register Loan**: Create a loan for an available book
3. **Register Return**: Process book returns
4. **List Books**: Display all books and their availability
5. **List Loans**: Show all registered loans

---

*Educational project demonstrating modularization concepts in Java*

**Author**: Pablo Tzeliks ([@PabloTzeliks](https://github.com/PabloTzeliks))
