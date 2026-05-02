# Library Management System 📚

A modern, full-stack Spring Boot application for managing a library's collection of books and authors. Built with Spring Boot 3, JPA, H2, and JSP.

## 🚀 Features

- **Inventory Dashboard**: View all books and authors in a clean, responsive interface.
- **Book Management**:
  - Add new books with details like title, genre, and price.
  - Link books to existing authors.
  - Edit existing book information.
- **Author Management**: Keep track of authors and their biographies.
- **Optimized Queries**: Uses custom JPQL Inner Joins for efficient data retrieval.
- **Auto-Population**: Comes pre-loaded with 10 sample authors and 10 books for immediate testing.
- **Premium UI**: Styled with a modern, glassmorphism-inspired CSS design.

## 🛠️ Tech Stack

- **Backend**: Spring Boot 3.2.5
- **Database**: H2 (In-memory)
- **ORM**: Spring Data JPA / Hibernate
- **View**: JSP (JavaServer Pages) with JSTL
- **Styling**: Vanilla CSS3
- **Testing**: JUnit 5, Mockito

## 📋 Prerequisites

- **Java 17 or higher**
- **Maven** (or use the included Maven Wrapper)

## ⚙️ Installation & Running

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ayushsingh199/Spring-Boot-Library-Management.git
   cd Spring-Boot-Library-Management
   ```

2. **Run the application**:
   Using the Maven Wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Access the App**:
   - Web App: [http://localhost:8080](http://localhost:8080)
   - H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
     - **JDBC URL**: `jdbc:h2:mem:librarydb`
     - **User**: `sa`
     - **Pass**: `password`

## 🧪 Testing

Run the automated test suite using:
```bash
./mvnw test
```

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
