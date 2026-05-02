package com.example.library.controller;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    // List all books and authors
    @GetMapping("/")
    public String listAll(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "list";
    }

    // Show form to add a new book
    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", libraryService.getAllAuthors());
        model.addAttribute("pageTitle", "Add New Book");
        return "form";
    }

    // Show form to edit an existing book
    @GetMapping("/edit-book/{id}")
    public String showEditBookForm(@PathVariable Long id, Model model) {
        Book book = libraryService.getBookById(id);
        if (book != null) {
            model.addAttribute("book", book);
            model.addAttribute("authors", libraryService.getAllAuthors());
            model.addAttribute("pageTitle", "Edit Book");
            return "form";
        }
        return "redirect:/";
    }

    // Handle form submission for saving/updating a book
    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            libraryService.saveBook(book);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", "Error saving book: " + e.getMessage());
            model.addAttribute("authors", libraryService.getAllAuthors());
            model.addAttribute("pageTitle", book.getId() == null ? "Add New Book" : "Edit Book");
            return "form";
        }
    }

    // Author Operations (Simplified for this task)
    @GetMapping("/add-author")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-form";
    }

    @PostMapping("/save-author")
    public String saveAuthor(@ModelAttribute("author") Author author) {
        libraryService.saveAuthor(author);
        return "redirect:/";
    }
}
