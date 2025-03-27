package com.trasky.onlineBookmanagementSystem.serviceImpl.service;

import com.trasky.onlineBookmanagementSystem.entity.Book;
import com.trasky.onlineBookmanagementSystem.exception.BookNotFoundException;
import com.trasky.onlineBookmanagementSystem.repo.BookRepo;
import com.trasky.onlineBookmanagementSystem.serviceImpl.BookServiceimp;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements BookServiceimp {
    private final BookRepo bookRepository;

    public BookService(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailabilityStatus(updatedBook.getAvailabilityStatus());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
