<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${pageTitle}</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <header>
            <h1>${pageTitle}</h1>
            <a href="/" class="btn btn-secondary">Back to List</a>
        </header>

        <div class="card">
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>

            <form action="/save-book" method="post">
                <input type="hidden" name="id" value="${book.id}">
                
                <div class="form-group">
                    <label for="title">Book Title</label>
                    <input type="text" id="title" name="title" value="${book.title}" required placeholder="e.g. The Great Gatsby">
                </div>

                <div class="form-group">
                    <label for="author">Author</label>
                    <select id="author" name="author.id" required>
                        <option value="">Select an Author</option>
                        <c:forEach var="author" items="${authors}">
                            <option value="${author.id}" ${book.author.id == author.id ? 'selected' : ''}>
                                ${author.name}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <label for="genre">Genre</label>
                    <input type="text" id="genre" name="genre" value="${book.genre}" required placeholder="e.g. Classic Literature">
                </div>

                <div class="form-group">
                    <label for="price">Price ($)</label>
                    <input type="number" step="0.01" id="price" name="price" value="${book.price}" required placeholder="0.00">
                </div>

                <div style="margin-top: 2rem;">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Save Book</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
