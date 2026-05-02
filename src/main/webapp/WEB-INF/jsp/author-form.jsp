<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Author</title>
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container" style="max-width: 600px;">
        <header>
            <h1>Add New Author</h1>
            <a href="/" class="btn btn-secondary">Back to List</a>
        </header>

        <div class="card">
            <form action="/save-author" method="post">
                <div class="form-group">
                    <label for="name">Author Name</label>
                    <input type="text" id="name" name="name" required placeholder="e.g. F. Scott Fitzgerald">
                </div>

                <div class="form-group">
                    <label for="bio">Biography</label>
                    <textarea id="bio" name="bio" rows="4" placeholder="Brief biography of the author..."></textarea>
                </div>

                <div style="margin-top: 2rem;">
                    <button type="submit" class="btn btn-primary" style="width: 100%;">Save Author</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
