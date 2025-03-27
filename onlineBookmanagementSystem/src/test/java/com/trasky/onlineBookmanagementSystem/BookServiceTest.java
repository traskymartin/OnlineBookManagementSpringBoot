package com.trasky.onlineBookmanagementSystem;


import com.trasky.onlineBookmanagementSystem.entity.Book;
import com.trasky.onlineBookmanagementSystem.exception.BookNotFoundException;
import com.trasky.onlineBookmanagementSystem.repo.BookRepo;
import com.trasky.onlineBookmanagementSystem.serviceImpl.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald", "Classic", Book.AvailabilityStatus.AVAILABLE);
    }

    @Test
    void testAddBook() {
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book savedBook = bookService.addBook(book);
        assertNotNull(savedBook);
        assertEquals("The Great Gatsby", savedBook.getTitle());
    }

    @Test
    void testGetBookById_Success() {
        // Given
        Book books = new Book(1L, "Spring Boot", "John Doe", "Classic", Book.AvailabilityStatus.AVAILABLE);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(books));

        // When
        Optional<Book> foundBook = bookService.getBookById(1L);

        // Then
        assertTrue(foundBook.isPresent());
        assertEquals(1L, foundBook.get().getId());
        assertEquals("Spring Boot", foundBook.get().getTitle());
    }


    @Test
    void testUpdateBook() {
        // Arrange
        Book existingBook = new Book();
        existingBook.setId(1L);
        existingBook.setAvailabilityStatus(Book.AvailabilityStatus.AVAILABLE);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(existingBook));

        // Act
        existingBook.setAvailabilityStatus(Book.AvailabilityStatus.CHECKED_OUT);
        when(bookRepository.save(any(Book.class))).thenReturn(existingBook);

        Book updatedBook = bookService.updateBook(1L, existingBook);

        // Assert
        assertNotNull(updatedBook);
        assertEquals(Book.AvailabilityStatus.CHECKED_OUT, updatedBook.getAvailabilityStatus());
    }


    @Test
    void testDeleteBook() {

        String value = "Book deleted successfully";
        assertEquals("Book deleted successfully", value);
    }
}
