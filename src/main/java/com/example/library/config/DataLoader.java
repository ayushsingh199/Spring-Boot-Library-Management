package com.example.library.config;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            // Create 10 Authors
            List<Author> authors = Arrays.asList(
                new Author("J.K. Rowling", "British author, best known for Harry Potter."),
                new Author("George R.R. Martin", "American novelist, author of A Song of Ice and Fire."),
                new Author("Stephen King", "Master of horror, supernatural fiction."),
                new Author("Agatha Christie", "The Queen of Mystery."),
                new Author("Ernest Hemingway", "American novelist and journalist."),
                new Author("Virginia Woolf", "English writer, pioneer of stream of consciousness."),
                new Author("Mark Twain", "The father of American literature."),
                new Author("Jane Austen", "English novelist known for social commentary."),
                new Author("Fyodor Dostoevsky", "Russian novelist, philosopher."),
                new Author("Haruki Murakami", "Japanese writer, surrealism and melancholia.")
            );
            authorRepository.saveAll(authors);

            // Fetch authors back to ensure we have IDs
            List<Author> savedAuthors = authorRepository.findAll();

            // Create 10 Books
            List<Book> books = Arrays.asList(
                new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 29.99, savedAuthors.get(0)),
                new Book("A Game of Thrones", "Epic Fantasy", 34.50, savedAuthors.get(1)),
                new Book("The Shining", "Horror", 24.99, savedAuthors.get(2)),
                new Book("Murder on the Orient Express", "Mystery", 19.99, savedAuthors.get(3)),
                new Book("The Old Man and the Sea", "Classic", 15.00, savedAuthors.get(4)),
                new Book("Mrs Dalloway", "Modernist", 18.00, savedAuthors.get(5)),
                new Book("Adventures of Huckleberry Finn", "Adventure", 12.99, savedAuthors.get(6)),
                new Book("Pride and Prejudice", "Romance", 14.50, savedAuthors.get(7)),
                new Book("Crime and Punishment", "Psychological Fiction", 22.00, savedAuthors.get(8)),
                new Book("Norwegian Wood", "Contemporary", 20.00, savedAuthors.get(9))
            );
            bookRepository.saveAll(books);

            System.out.println("Database populated with 10 authors and 10 books.");
        };
    }
}
