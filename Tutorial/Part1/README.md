# Advanced Java Tutorial - Part 1

## Overview

This repository contains a comprehensive Java tutorial project covering fundamental Java concepts, database connectivity (JDBC), and web application development using Servlets. The project is organized as a progressive learning path, demonstrating practical implementations of banking systems, student management, and web applications.

## Project Structure

```
Part1/
├── Main.java                     # Placeholder for main projects
├── README.md                     # This documentation file
├── talk.md                       # Servlet configuration guide
└── src/
    ├── javabasics/              # Java fundamentals (jan19-jan22)
    ├── week1/                   # JDBC Basics - Connection & CRUD
    ├── week2/                   # Advanced JDBC - Transactions, Pooling
    ├── week6/                   # Reserved for future content
    ├── servlets/                # Web development - Servlet/Tomcat
    └── web/                     # Frontend - HTML forms
```

## Learning Modules

### 1. Java Basics (`src/javabasics/`)

Foundation-level Java programming covering object-oriented concepts, control flow, and practical applications.

#### January 19 - ATM Application
- **ATMApp.java**: Simple ATM class with balance management, deposit, withdraw, and balance display methods
- **Pro1.java - Pro5.java**: Additional practice problems

**Key Concepts:**
- Classes and methods
- Conditional logic and input validation
- Scanner-based user interaction

#### January 20 - Student Management
- **StudentApp.java**: Student management operations
- **Pro.java**: Additional exercises

#### January 21 - Butterfly Catching Application
- **Butterfly.java, CatchButterfly.java**: Game logic and object relationships
- **Pro1.java, Pro2.java**: Practice exercises

#### January 22 - Problem Solving
- **Pro1.java - Pro6.java**: Algorithmic problems and consolidation exercises

### 2. JDBC - Week 1 (`src/week1/`)

Database connectivity fundamentals using JDBC and MySQL.

| File | Purpose |
|------|---------|
| `JDBC_Connect.java` | Database connection setup and table creation |
| `JDBC_Select.java` | SELECT queries and data retrieval |
| `JDBC_Insert.java` | INSERT operations for new records |
| `JDBC_Update.java` | UPDATE operations for existing records |
| `JDBC_Delete.java` | DELETE operations for record removal |
| `Insert_records.java` | Batch insertion of multiple records |
| `Movie.java` | Domain model class for movie data |

**Key Concepts:**
- JDBC driver loading and connection establishment
- Statement and PreparedStatement usage
- CRUD operations (Create, Read, Update, Delete)
- Connection management

### 3. JDBC - Week 2 (`src/week2/`)

Advanced JDBC features for production-ready database applications.

| File | Purpose |
|------|---------|
| `Transactions.java` | Transaction management with commit/rollback |
| `Batchprocessing.java` | Batch operations for bulk data processing |
| `Callablestatement.java` | Stored procedure execution |
| `ConnectionPooling.java` | Connection pooling for performance |
| `CursorMovementMethods.java` | ResultSet navigation methods |
| `Resultsetmetadata.java` | Database metadata inspection |
| `PaginationDemo.java` | Implementing data pagination |
| `QuestionBank.java` | Interview questions and practice |

**Key Concepts:**
- ACID transaction properties
- Batch processing for efficiency
- Connection pooling
- ResultSet metadata and cursor control

### 4. Web Development - Servlets (`src/servlets/`)

Building web applications using Jakarta Servlet API with Apache Tomcat.

| File | Purpose | HTTP Methods |
|------|---------|--------------|
| `StudentServlet.java` | Student management operations | GET, POST |
| `Admin.java` | Admin dashboard | Admin operations |
| `Dashboard.java` | User dashboard | Display dashboard |
| `Filter_Auth.java` | Authentication filter | Request filtering |
| `SessionManagement.java` | Session handling | Session management |
| `Logout.java` | User logout | Session cleanup |
| `Week4pro.java` | Week 4 project | General operations |

**Key Features:**
- `@WebServlet` annotation for URL mapping
- Request/Response handling
- Form data processing
- Database integration
- Request forwarding

### 5. Web Frontend (`src/web/`)

HTML forms for web application interfaces.

- **form.html**: Login/registration form with username and password fields
- **summary.html**: Results display page

### 6. Main Entry Point (`Main.java`)

Placeholder for main project coordination with planned implementations:
- Student Management System
- Banking System
- Library Management System

## Technologies Used

- **Java**: Core programming language
- **JDBC**: Database connectivity
- **Jakarta Servlet API**: Web application development
- **Apache Tomcat 10.1**: Application server
- **MySQL**: Database management system
- **HTML/CSS**: Frontend development

## Setup and Configuration

### Database Setup
- Database: `subhamdb`
- Use MySQL for all JDBC examples

### Servlet Configuration
- Add `servlet-api.jar` to project dependencies with "Provided" scope
- Method signatures must include `throws ServletException, IOException`
- Uses Jakarta namespace (not javax)

### Development Environment
- IntelliJ IDEA with Smart Tomcat plugin
- JDK appropriate for Jakarta Servlet API

## Learning Progression

1. **Phase 1**: Java Basics (OOP, control flow, practical applications)
2. **Phase 2**: JDBC Fundamentals (connection, CRUD operations)
3. **Phase 3**: Advanced JDBC (transactions, batch processing, pooling)
4. **Phase 4**: Web Development (Servlets, web applications)
5. **Future Phases**: Advanced web patterns and frameworks

## Project Themes

The tutorial demonstrates practical implementations of:
- **Banking System**: ATM operations with balance management
- **Student Management**: Form-based data management via servlets
- **Database Operations**: Complete CRUD with advanced features

## Important Notes

- Refer to `talk.md` for detailed servlet setup instructions
- Ensure proper dependency management for servlet API
- Database connections require MySQL setup with appropriate credentials
- All servlets use Jakarta Servlet API (modern standard)

This structure provides a complete learning path from basic Java programming through production-ready database applications and web development.