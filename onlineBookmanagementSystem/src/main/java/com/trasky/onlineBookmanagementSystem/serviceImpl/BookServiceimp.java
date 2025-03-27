package com.trasky.onlineBookmanagementSystem.serviceImpl;

import com.trasky.onlineBookmanagementSystem.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookServiceimp {
    Book addBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Optional<Book> getBookByTitle(String title);
    Book updateBook(Long id, Book updatedBook);
    void deleteBook(Long id);
}
