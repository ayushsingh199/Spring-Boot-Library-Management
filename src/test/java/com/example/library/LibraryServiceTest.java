package com.example.library;

import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class LibraryServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private LibraryService libraryService;

    @Test
    void testGetAllBooks() {
        Author author = new Author("Test Author", "Bio");
        Book book = new Book("Test Book", "Genre", 10.0, author);
        
        when(bookRepository.findAllBooksWithAuthors()).thenReturn(Collections.singletonList(book));
        
        List<Book> result = libraryService.getAllBooks();
        
        assertEquals(1, result.size());
        assertEquals("Test Book", result.get(0).getTitle());
        verify(bookRepository, times(1)).findAllBooksWithAuthors();
    }

    @Test
    void testSaveAuthor() {
        Author author = new Author("New Author", "Bio");
        when(authorRepository.save(any(Author.class))).thenReturn(author);
        
        Author saved = libraryService.saveAuthor(author);
        
        assertNotNull(saved);
        assertEquals("New Author", saved.getName());
        verify(authorRepository, times(1)).save(author);
    }
}
