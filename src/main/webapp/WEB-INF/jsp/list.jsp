<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management System</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <header>
            <h1>Library Inventory</h1>
            <div>
                <a href="/add-author" class="btn btn-secondary">Add Author</a>
                <a href="/add-book" class="btn btn-primary">Add Book</a>
            </div>
        </header>

        <div class="card">
            <h2>Books Collection</h2>
            <c:if test="${empty books}">
                <p>No books found. Add some sample data!</p>
            </c:if>
            <c:if test="${not empty books}">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Author</th>
                            <th>Genre</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                               <td>${book.id}</td>
                               <td>${book.title}</td>
                               <td>${book.author.name}</td>
                               <td>${book.genre}</td>
                               <td>$${book.price}</td>
                               <td>
                                   <a href="/edit-book/${book.id}" class="btn btn-secondary" style="padding: 0.4rem 0.8rem; font-size: 0.8rem;">Edit</a>
                               </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>

        <div class="card">
            <h2>Authors</h2>
            <c:if test="${empty authors}">
                <p>No authors found.</p>
            </c:if>
            <c:if test="${not empty authors}">
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Bio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="author" items="${authors}">
                            <tr>
                               <td>${author.id}</td>
                               <td>${author.name}</td>
                               <td>${author.bio}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>
