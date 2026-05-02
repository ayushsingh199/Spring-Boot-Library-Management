# Submission: Spring Boot Library Management System

## Entity Relationship Design
The application manages two primary entities: **Author** and **Book**.
- **Author**: Represents a writer with a unique ID, name, and biography.
- **Book**: Represents a literary work with a title, genre, price, and a reference to its author.
- **Relationship**: A **One-to-Many** relationship exists between Author and Book. One author can write multiple books, while each book is associated with exactly one author. This is implemented using JPA `@OneToMany` (in `Author`) and `@ManyToOne` (in `Book`).

## Implementation Details

### 1. Populate Database
We use a `CommandLineRunner` bean in the `DataLoader` class to automatically populate the H2 in-memory database with 10 authors and 10 books upon application startup. This ensures the application is ready for testing immediately.

### 2. Create Operation
- **Form**: Implemented in `form.jsp` and `author-form.jsp`.
- **Controller**: `LibraryController.saveBook()` handles the POST request.
- **Exception Handling**: A `try-catch` block in the controller catches data integrity violations (e.g., missing author) and returns the user to the form with an error message.

### 3. Read Operation
- **List View**: `list.jsp` displays all books and authors using JSTL `<c:forEach>`.
- **Inner Join**: The `BookRepository` includes a custom JPQL query:
  ```java
  @Query("SELECT b FROM Book b INNER JOIN b.author a")
  List<Book> findAllBooksWithAuthors();
  ```
  This ensures that we fetch books along with their associated author data in a single optimized query.

### 4. Update Operation
- **Functionality**: Users can click "Edit" on any book in the list.
- **Controller**: `LibraryController.showEditBookForm()` fetches the existing entity and binds it to the form. `saveBook()` then handles the update (JPA handles the merge automatically since the ID is present).

## Challenges Faced & Solutions
- **JSP Support in Spring Boot 3**: Spring Boot 3 requires specific dependencies for JSP (Jakarta Namespace). I resolved this by using the `jakarta.servlet.jsp.jstl` dependencies instead of the older `javax` ones.
- **Inner Join Optimization**: Ensuring that the author data was fetched efficiently without N+1 problems was handled by using a custom `@Query` with an INNER JOIN.

## Github URL
*(Placeholder: You can push this code to your repository and paste the link here)*

---
**Note**: You can export this document to PDF using any Markdown editor or by printing to PDF from a browser.
